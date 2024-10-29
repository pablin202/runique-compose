package com.pdm.runique.core.data.di

import com.pdm.runique.core.data.auth.EncryptedSessionStorage
import com.pdm.runique.core.data.networking.HttpClientFactory
import com.pdm.runique.core.data.run.OfflineFirstRunRepository
import com.pdm.runique.core.domain.SessionStorage
import com.pdm.runique.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }

    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}