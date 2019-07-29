package com.client.googlenotes.data.store

import com.client.googlenotes.data.store.dataStore.CacheDataStore
import com.client.googlenotes.data.store.dataStore.RemoteDataStore
import javax.inject.Inject

class DataStoreFactory<T> @Inject constructor(private val cacheDataStore: CacheDataStore,
                                           private val remoteDateStore: RemoteDataStore) {

    @Suppress("UNCHECKED_CAST")
    fun create(force: Boolean): T{
        return if(force){
            remoteDateStore as T
        }else {
            cacheDataStore as T
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun create(): T = cacheDataStore as T
}
