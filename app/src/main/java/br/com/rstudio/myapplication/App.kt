package br.com.rstudio.myapplication

import android.app.Application
import br.com.rstudio.myapplication.featureA.di.ProductsModule
import br.com.rstudio.myapplication.featureb.di.UserModule
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
            modules(UserModule.module)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}