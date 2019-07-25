package com.client.googlenotes.data.store.notes

import com.client.googlenotes.data.cache.NotesCache
import com.client.googlenotes.data.database.models.NoteTableEntity
import io.reactivex.Single
import javax.inject.Inject

class CacheDataStore @Inject constructor(private val noteCache: NotesCache) : NotesDataStore {



    override fun getNote(id: Long): Single<NoteTableEntity> {
        return Single.defer {
            return@defer noteCache
                .getItem(id)
        }
    }


    override fun getNotes(): Single<List<NoteTableEntity>> {
        return Single.defer {
            return@defer noteCache
                .get()
        }
    }
}