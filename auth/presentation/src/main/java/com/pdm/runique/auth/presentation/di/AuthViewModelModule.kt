package com.pdm.runique.auth.presentation.di

import com.pdm.runique.auth.presentation.login.LoginViewModel
import com.pdm.runique.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}