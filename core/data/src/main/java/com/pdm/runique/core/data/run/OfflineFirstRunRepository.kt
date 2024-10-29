package com.pdm.runique.core.data.run

import com.pdm.runique.core.domain.run.LocalRunDataSource
import com.pdm.runique.core.domain.run.RemoteRunDataSource
import com.pdm.runique.core.domain.run.Run
import com.pdm.runique.core.domain.run.RunId
import com.pdm.runique.core.domain.run.RunRepository
import com.pdm.runique.core.domain.util.DataError
import com.pdm.runique.core.domain.util.EmptyResult
import com.pdm.runique.core.domain.util.asEmptyDataResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow

class OfflineFirstRunRepository(
    private val localRunDataSource: LocalRunDataSource,
    private val remoteRunDataSource: RemoteRunDataSource,
    private val applicationScope: CoroutineScope
) : RunRepository {

    override fun getRuns(): Flow<List<Run>> {
        return localRunDataSource.getRuns()
    }

    override suspend fun fetchRuns(): EmptyResult<DataError> {
        return when (val result = remoteRunDataSource.getRuns()) {
            is com.pdm.runique.core.domain.util.Result.Error -> result.asEmptyDataResult()
            is com.pdm.runique.core.domain.util.Result.Success -> {
                applicationScope.async {
                    localRunDataSource.upsertRuns(result.data).asEmptyDataResult()
                }.await()
            }
        }
    }

    override suspend fun upsertRun(run: Run, mapPicture: ByteArray): EmptyResult<DataError> {
        val localResult = localRunDataSource.upsertRun(run)
        if (localResult !is com.pdm.runique.core.domain.util.Result.Success) {
            return localResult.asEmptyDataResult()
        }

        val runWithId = run.copy(id = localResult.data)
        val remoteResult = remoteRunDataSource.postRun(
            run = runWithId,
            mapPicture = mapPicture
        )

        return when (remoteResult) {
            is com.pdm.runique.core.domain.util.Result.Error -> {
                com.pdm.runique.core.domain.util.Result.Success(Unit)
            }

            is com.pdm.runique.core.domain.util.Result.Success -> {
                applicationScope.async {
                    localRunDataSource.upsertRun(remoteResult.data).asEmptyDataResult()
                }.await()
            }
        }
    }

    override suspend fun deleteRun(id: RunId) {
        localRunDataSource.deleteRun(id)

        val remoteResult = applicationScope.async {
            remoteRunDataSource.deleteRun(id)
        }.await()
    }
}