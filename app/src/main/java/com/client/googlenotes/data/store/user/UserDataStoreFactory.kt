package com.client.googlenotes.data.store.user

import com.client.googlenotes.data.store.dataStore.CacheDataStore
import javax.inject.Inject

class UserDataStoreFactory @Inject constructor(private val cacheDataStore: CacheDataStore) {

    fun create(): UserDataStore{
        return cacheDataStore
    }
}