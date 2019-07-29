package com.client.googlenotes.data.displays

import com.client.googlenotes.data.database.models.extentType.Coordinate

data class NoteDisplay (private val id: Long,
                   private val title: String,
                   private val content: String,
                   private val color: Int,
                   private val priority: Int,
                   private val coordinate: Coordinate,
                   private val image: List<ByteArray>,
                   private val data: String)