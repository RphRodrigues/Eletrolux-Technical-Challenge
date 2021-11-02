package br.com.rstudio.myapplication

import android.app.Application
import br.com.rstudio.myapplication.core.di.AppModule
import br.com.rstudio.myapplication.core.di.NetworkingModule
import br.com.rstudio.myapplication.feature.di.UserModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                AppModule.module,
                NetworkingModule.module,
                UserModule.module
            )
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}