package com.client.googlenotes.data.store.dataStore

import com.client.googlenotes.data.cache.NotesCache
import com.client.googlenotes.data.database.models.NoteTableEntity
import com.client.googlenotes.data.store.notes.NotesDataStore
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataStore @Inject constructor(private val cache: NotesCache) :
    NotesDataStore {

    override fun putNote(item: NoteTableEntity): Single<NoteTableEntity> {

        //TODO здесь будет работы с сетью, временно данные беруться из кеша

        return cache.put(item)
    }

    override fun putNotes(notes: List<NoteTableEntity>): Single<List<NoteTableEntity>> {

        //TODO здесь будет работы с сетью, временно данные беруться из кеша
        return cache.put(notes)
    }

    override fun getNotes(): Single<List<NoteTableEntity>> {
        //TODO здесь будет работы с сетью, временно данные беруться из кеша

        return cache.get()
    }

    override fun getNote(id: Long): Single<NoteTableEntity> {
        return cache
            .getItem(id)
    }
}