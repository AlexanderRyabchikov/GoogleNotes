package com.client.googlenotes.data.store.user

import com.client.googlenotes.data.database.models.UserEntity
import com.client.googlenotes.data.store.DataStore
import io.reactivex.Single

interface UserDataStore: DataStore {

    fun getUserName(): Single<String>
    fun getUser(): Single<UserEntity>
    fun putUser(user: UserEntity): Single<UserEntity>

}