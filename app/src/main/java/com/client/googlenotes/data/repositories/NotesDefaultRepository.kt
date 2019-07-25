package com.client.googlenotes.data.repositories

import com.client.googlenotes.data.database.models.NoteTableEntity
import com.client.googlenotes.data.store.notes.NotesDataStoreFactory
import io.reactivex.Single
import javax.inject.Inject

class NotesDefaultRepository @Inject constructor(private val notesFactory: NotesDataStoreFactory) : NotesRepository{



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