package com.client.googlenotes.app

import android.support.multidex.MultiDexApplication

class App : MultiDexApplication() {

    private lateinit var appComponent:AppComponent


    override fun onCreate() {
        super.onCreate()

        initComponents()
    }

    private fun initComponents() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .apiModule(ApiModule(BuildConfig.ServerUrl + BuildConfig.API))
            .build();
    }

    fun getAppComponent() :AppComponent = appComponent
}