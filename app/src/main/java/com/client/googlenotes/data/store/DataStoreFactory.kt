package com.client.googlenotes.data.store

import javax.inject.Inject

class DataStoreFactory<T> @Inject constructor(private val cacheDataStore: T,
                                           private val remoteDateStore: T) {

    fun create(force: Boolean): T{
        return if(force){
            remoteDateStore
        }else {
            cacheDataStore
        }
    }

    fun create(): T = cacheDataStore
}
