package com.chernikova.pethelp

import android.app.Application
import com.chernikova.pethelp.di.AppComponent
import com.chernikova.pethelp.di.modules.DatabaseModule
import com.chernikova.pethelp.di.modules.DomainModule
import com.chernikova.remote_module.DaggerRemoteComponent
import com.chernikova.pethelp.di.DaggerAppComponent


class App : Application() {
    lateinit var dagger: AppComponent
    var isPromoShown = false

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        val remoteProvider = DaggerRemoteComponent.create()
        dagger = DaggerAppComponent.builder()
            .remoteProvider(remoteProvider)
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }
        companion object {
            lateinit var instance: App
                private set
        }
    }