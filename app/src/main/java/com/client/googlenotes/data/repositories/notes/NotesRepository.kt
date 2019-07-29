package com.client.googlenotes.data.repositories.notes

import com.client.googlenotes.data.database.models.NoteTableEntity
import io.reactivex.Single

interface NotesRepository {

    fun getNotes(force: Boolean): Single<List<NoteTableEntity>>

    fun getNote(id: Long) : Single<NoteTableEntity>

    fun putNotes(list: List<NoteTableEntity>, force: Boolean): Single<List<NoteTableEntity>>

    fun putNote(item: NoteTableEntity, force: Boolean) : Single<NoteTableEntity>
}