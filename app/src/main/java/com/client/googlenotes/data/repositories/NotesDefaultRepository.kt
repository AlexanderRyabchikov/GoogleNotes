package com.client.googlenotes.data.repositories

import com.client.googlenotes.data.database.models.NoteTableEntity
import com.client.googlenotes.data.database.models.container.ListDataContainer
import com.client.googlenotes.data.database.models.container.SingleDataContainer
import com.client.googlenotes.data.store.notes.NotesDataStoreFactory
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class NotesDefaultRepository @Inject constructor(private val notesFactory: NotesDataStoreFactory) : NotesRepository{


    override fun getNote(id: Long): Single<NoteTableEntity> {

        return Single.defer {
            return@defer notesFactory
                .create(false)
                .getNote(id)
        }

    }


    override fun getNotes(force: Boolean): Single<List<NoteTableEntity>>{
        return Single.defer {
            return@defer notesFactory
                .create(force)
                .getNotes()
        }
    }
}