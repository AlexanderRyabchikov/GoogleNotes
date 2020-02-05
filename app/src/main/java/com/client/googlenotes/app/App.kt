package com.client.googlenotes.app

import androidx.multidex.BuildConfig
import androidx.multidex.MultiDexApplication
import com.client.googlenotes.app.module.ApiModule
import com.client.googlenotes.app.module.AppModule
import com.client.googlenotes.dagger.core.AppComponent
import com.client.googlenotes.dagger.core.DaggerAppComponent
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.orhanobut.hawk.Hawk
import io.fabric.sdk.android.Fabric

class App : MultiDexApplication() {

    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

//        Fabric.with(
//            this, Crashlytics.Builder()
//                .core(CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build()).build()
//        )



        Hawk.init(this).build()

        initComponents()

    }

    private fun initComponents() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .apiModule(ApiModule(/*BuildConfig.ServerUrl + BuildConfig.API*/"https://restapi-stage.mdtest.org/"))
            .build()
    }

    fun getAppComponent() :AppComponent = appComponent
}