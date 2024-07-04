package com.pdm.runique.run.location.di

import com.pdm.runique.run.domain.LocationObserver
import com.pdm.runique.run.location.AndroidLocationObserver
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val locationModule = module {
    singleOf(::AndroidLocationObserver).bind<LocationObserver>()
}