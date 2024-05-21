package com.pdm.runique.core.data.networking.di

import com.pdm.runique.core.data.networking.HttpClientFactory
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
}