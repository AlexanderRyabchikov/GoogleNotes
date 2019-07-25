package com.client.googlenotes.dagger.core

import android.content.Context
import com.client.googlenotes.app.module.ApiModule
import com.client.googlenotes.app.module.AppModule
import com.client.googlenotes.app.module.RepositoryModule
import com.client.googlenotes.data.repositories.NotesRepository
import com.client.googlenotes.ui.base.AbstractActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RepositoryModule::class, ApiModule::class])
interface AppComponent {
    fun context(): Context
    //fun apiInterfaces(): ApiInterface

    fun inject(activity: AbstractActivity)

    fun notesRepository(): NotesRepository
}