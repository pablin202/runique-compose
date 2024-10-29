package com.pdm.runique.run.data.di

import com.pdm.runique.core.domain.run.SyncRunScheduler
import org.koin.dsl.module
import org.koin.androidx.workmanager.dsl.workerOf
import com.pdm.runique.run.data.CreateRunWorker
import com.pdm.runique.run.data.DeleteRunWorker
import com.pdm.runique.run.data.FetchRunsWorker
import com.pdm.runique.run.data.SyncRunWorkerScheduler
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}