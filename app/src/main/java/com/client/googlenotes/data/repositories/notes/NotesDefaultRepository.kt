package com.client.googlenotes.data.repositories.notes

import com.client.googlenotes.data.database.models.NoteTableEntity
import com.client.googlenotes.data.store.DataStoreFactory
import com.client.googlenotes.data.store.notes.NotesDataStore
import io.reactivex.Single
import javax.inject.Inject

class NotesDefaultRepository @Inject constructor(private val notesFactory: DataStoreFactory<NotesDataStore>) :
    NotesRepository {



    override fun putNotes(list: List<NoteTableEntity>, force: Boolean): Single<List<NoteTableEntity>> {

        return Single.defer {
            return@defer notesFactory
                .create(force)
                .putNotes(list)
        }

    }

    override fun putNote(item: NoteTableEntity, force: Boolean): Single<NoteTableEntity> {

        return Single.defer {
            return@defer notesFactory
                .create(force)
                .putNote(item)
        }
    }


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