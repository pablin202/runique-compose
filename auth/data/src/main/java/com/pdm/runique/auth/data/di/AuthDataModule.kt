package com.pdm.runique.auth.data.di

import com.pdm.runique.auth.data.EmailPatternValidator
import com.pdm.runique.auth.domain.PatternValidator
import com.pdm.runique.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }

    singleOf(::UserDataValidator)
}