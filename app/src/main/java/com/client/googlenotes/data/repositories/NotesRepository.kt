package com.client.googlenotes.data.repositories

import com.client.googlenotes.data.database.models.NoteTableEntity
import io.reactivex.Single

interface NotesRepository {

    fun getNotes(force: Boolean): Single<List<NoteTableEntity>>

    fun getNote(id: Long) : Single<NoteTableEntity>
}