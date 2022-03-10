package com.tcorredo.projectmvc_mvp_mvvm

import android.app.Application
import com.tcorredo.projectmvc_mvp_mvvm.di.apiModule
import com.tcorredo.projectmvc_mvp_mvvm.di.factoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    apiModule,
                    factoryModule
                )
            )
        }
    }
}