package com.client.googlenotes.data.mappers

import com.client.googlenotes.data.database.models.NoteTableEntity
import com.client.googlenotes.data.displays.NoteDisplay
import javax.inject.Inject

class NoteEntityToDisplayMapper @Inject constructor() : AbstractMapper<NoteTableEntity, NoteDisplay>() {


    override fun map(value: NoteTableEntity): NoteDisplay {

        return  NoteDisplay(
            value.getId(),
            value.getTitle(),
            value.getContent(),
            value.getColor(),
            value.getPriority(),
            value.getCoordinate(),
            value.getImage(),
            value.getDate()
        )

    }
}