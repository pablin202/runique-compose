package com.pdm.runique.core.domain.run

import com.pdm.runique.core.domain.util.DataError
import com.pdm.runique.core.domain.util.Result
import com.pdm.runique.core.domain.util.EmptyResult

interface RemoteRunDataSource {
    suspend fun getRuns(): Result<List<Run>, DataError.Network>
    suspend fun postRun(run: Run, mapPicture: ByteArray): Result<Run, DataError.Network>
    suspend fun deleteRun(id: String): EmptyResult<DataError.Network>
}