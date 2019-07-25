package com.client.googlenotes.data.store.notes
import javax.inject.Inject

class NotesDataStoreFactory @Inject constructor(private val cacheDataStore: CacheDataStore,
                                                private val remoteDateStore: RemoteDataStore) {


    fun create(force: Boolean): NotesDataStore{
        return if (force) {
                        remoteDateStore
                    } else {
                        cacheDataStore
                    }
    }
}