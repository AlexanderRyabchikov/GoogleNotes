package com.client.googlenotes.app

import android.support.multidex.BuildConfig
import android.support.multidex.MultiDexApplication
import com.client.googlenotes.app.module.ApiModule
import com.client.googlenotes.app.module.AppModule
import com.client.googlenotes.dagger.core.AppComponent
import com.client.googlenotes.dagger.core.DaggerAppComponent

class App : MultiDexApplication() {

    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

        initComponents()
    }

    private fun initComponents() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .apiModule(ApiModule(/*BuildConfig.ServerUrl + BuildConfig.API*/))
            .build()
    }

    fun getAppComponent() :AppComponent = appComponent
}