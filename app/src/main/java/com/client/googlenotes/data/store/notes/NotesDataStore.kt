package com.client.googlenotes.data.store.notes

import com.client.googlenotes.data.database.models.NoteTableEntity
import io.reactivex.Single

interface NotesDataStore {

    fun getNotes(): Single<List<NoteTableEntity>>

    fun getNote(id: Long): Single<NoteTableEntity>
}