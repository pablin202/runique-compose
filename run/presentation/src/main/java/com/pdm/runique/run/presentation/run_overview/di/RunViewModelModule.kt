package com.pdm.runique.run.presentation.run_overview.di

import com.pdm.runique.run.presentation.run_overview.RunOverviewViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runViewModelModule = module {
    singleOf(::RunOverviewViewModel)
}