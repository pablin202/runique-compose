package com.pdm.runique.run.presentation.di

import com.pdm.runique.run.presentation.active_run.ActiveRunViewModel
import com.pdm.runique.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runViewModelModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}