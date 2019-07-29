package com.client.googlenotes.data.mappers

import com.client.googlenotes.data.database.models.UserEntity
import com.client.googlenotes.data.displays.UserDisplay
import javax.inject.Inject

class UserEntityToDisplayMapper @Inject constructor(): AbstractMapper<UserEntity, UserDisplay>() {

    override fun map(value: UserEntity): UserDisplay {

        return UserDisplay(
            value.getId(),
            value.getName(),
            value.getPhone(),
            value.getPhoto(),
            value.getEmail()
        )

    }
}