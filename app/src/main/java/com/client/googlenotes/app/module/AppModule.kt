package com.client.googlenotes.app.module

import android.content.Context
import com.client.googlenotes.BuildConfig
import com.client.googlenotes.data.database.AppDataSource
import com.client.googlenotes.data.database.models.Models
import dagger.Module
import dagger.Provides
import io.requery.Persistable
import io.requery.android.sqlite.DatabaseSource
import io.requery.reactivex.ReactiveEntityStore
import io.requery.reactivex.ReactiveSupport
import io.requery.sql.EntityDataStore
import io.requery.sql.TableCreationMode
import javax.inject.Singleton

@Module
class AppModule (private val context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context = context


    @Provides
    @Singleton
    fun providesDataStore(): ReactiveEntityStore<Persistable>{
        val source: DatabaseSource = AppDataSource(context, Models.DEFAULT, AppDataSource.DATABASE_VERSION)

        source.setLoggingEnabled(true)

        if (BuildConfig.DEBUG){
            source.setTableCreationMode(TableCreationMode.DROP_CREATE)
        }

        return ReactiveSupport.toReactiveStore(EntityDataStore<Persistable>(source.configuration))
    }
}