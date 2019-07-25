package com.client.googlenotes.data.store

import javax.inject.Inject

interface DataFactory<T>{
    fun create(force: Boolean): T
    fun create(): T
}

class DataStoreFactory<T> @Inject constructor(private val cacheDataStore: T,
                                           private val remoteDateStore: T) : DataFactory<T> {

    override fun create(force: Boolean): T{
        return if(force){
            remoteDateStore
        }else {
            cacheDataStore
        }
    }

    override fun create(): T = cacheDataStore
}
