package com.pdm.analitycs.data.di

import com.pdm.runique.analitycs.domain.AnalyticsRepository
import com.pdm.analitycs.data.RoomAnalyticsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
}