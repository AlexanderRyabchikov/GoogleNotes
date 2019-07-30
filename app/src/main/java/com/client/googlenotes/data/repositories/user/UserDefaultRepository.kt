package com.client.googlenotes.data.repositories.user

import com.client.googlenotes.data.database.models.UserEntity
import com.client.googlenotes.data.store.user.UserDataStoreFactory
import io.reactivex.Single
import javax.inject.Inject


class UserDefaultRepository @Inject constructor(private val userFactory: UserDataStoreFactory):
    UserRepository {

    override fun getUser(): Single<UserEntity> = Single.defer {
        return@defer userFactory
            .create()
            .getUser()
    }


    override fun putUser(user: UserEntity): Single<UserEntity> = Single.defer {

            return@defer userFactory
                .create()
                .putUser(user)
        }
}