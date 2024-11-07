package com.pdm.runique.analitycs.presentation.di

import com.pdm.runique.analitycs.presentation.AnalyticsDashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val analyticsPresentationModule = module {
    viewModelOf(::AnalyticsDashboardViewModel)
}