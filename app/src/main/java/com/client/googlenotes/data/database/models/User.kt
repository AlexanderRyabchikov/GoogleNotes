package com.client.googlenotes.data.database.models

import io.requery.Entity
import io.requery.Generated
import io.requery.Key
import io.requery.Persistable

@Entity
interface User: Persistable {

    @Key
    @Generated
    fun getId(): Long

    fun getName(): String

    fun getPhone(): String

    fun getPhoto(): String

    fun getEmail(): String

}