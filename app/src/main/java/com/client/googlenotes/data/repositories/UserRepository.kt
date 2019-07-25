package com.client.googlenotes.data.repositories

import com.client.googlenotes.data.database.models.UserEntity
import io.reactivex.Single

interface UserRepository {

    fun getUser(): Single<UserEntity>

    fun putUser(user: UserEntity): Single<UserEntity>

}