package com.pdm.runique.run.network.di

import com.pdm.runique.core.domain.run.RemoteRunDataSource
import com.pdm.runique.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}