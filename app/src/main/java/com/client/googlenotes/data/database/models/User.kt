package com.client.googlenotes.data.database.models

import io.requery.Entity
import io.requery.Key
import io.requery.Persistable

@Entity
interface User: Persistable {
    @Key
    fun getId(): Long
}