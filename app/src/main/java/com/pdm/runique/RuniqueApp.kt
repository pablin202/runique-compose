package com.pdm.runique

import android.app.Application
import com.pdm.runique.auth.data.di.authDataModule
import com.pdm.runique.auth.presentation.di.authViewModelModule
import com.pdm.runique.core.data.di.coreDataModule
import com.pdm.runique.di.appModule
import com.pdm.runique.run.presentation.di.runViewModelModule
import timber.log.Timber
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RuniqueApp: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                authViewModelModule,
                runViewModelModule,
                appModule,
                coreDataModule
            )
        }
    }
}