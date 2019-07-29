package com.client.googlenotes.data.database.models

import com.client.googlenotes.data.database.models.extentType.Coordinate
import io.requery.Entity
import io.requery.Generated
import io.requery.Key
import io.requery.Persistable

@Entity
interface NoteTable: Persistable {

    @Key
    @Generated
    fun getId(): Long

    fun getTitle(): String

    fun getContent(): String

    fun getColor(): Int

    fun getPriority(): Int

    fun getCoordinate(): Coordinate

    fun getImage(): List<ByteArray>

    fun getDate(): String
}