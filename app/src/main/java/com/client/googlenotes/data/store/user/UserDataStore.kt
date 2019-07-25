package com.client.googlenotes.data.store.user

import com.client.googlenotes.data.database.models.UserEntity
import io.reactivex.Single

interface UserDataStore {

    fun getUser(): Single<UserEntity>
    fun putUser(user: UserEntity): Single<UserEntity>

}