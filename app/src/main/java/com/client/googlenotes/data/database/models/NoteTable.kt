package com.client.googlenotes.data.database.models

import io.requery.Entity
import io.requery.Key
import io.requery.Persistable

@Entity
interface NoteTable: Persistable {

    @Key
    fun getId(): Long
}