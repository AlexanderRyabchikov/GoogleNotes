package com.client.googlenotes.data.store.notes

import com.client.googlenotes.data.store.dataStore.CacheDataStore
import com.client.googlenotes.data.store.dataStore.RemoteDataStore
import javax.inject.Inject

class NotesDataStoreFactory @Inject constructor(private val cacheDataStore: CacheDataStore,
                                                private val remoteDataStore: RemoteDataStore) {

    fun create(force: Boolean): NotesDataStore{
        return if(force){
            remoteDataStore
        }else {
            cacheDataStore
        }
    }
}