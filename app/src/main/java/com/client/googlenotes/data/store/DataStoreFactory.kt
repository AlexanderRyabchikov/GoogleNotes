package com.client.googlenotes.data.store

import com.client.googlenotes.data.store.dataStore.CacheDataStore
import com.client.googlenotes.data.store.dataStore.RemoteDataStore
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class DataStoreFactory<T : DataStore> @Inject constructor(private val cacheDataStore: CacheDataStore,
                                              private val remoteDataStore: RemoteDataStore){

    fun create(force: Boolean): T {
        return if(force){
            remoteDataStore as T
        }else {
            cacheDataStore as T
        }
    }

    fun create(): T{
        return cacheDataStore as T
    }
}