package com.client.googlenotes.data.cache

import com.client.googlenotes.app.PREF_USER_ID
import com.client.googlenotes.data.database.models.UserEntity
import com.orhanobut.hawk.Hawk
import io.reactivex.Single
import io.requery.Persistable
import io.requery.reactivex.ReactiveEntityStore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserCache @Inject constructor(private val store: ReactiveEntityStore<Persistable>) {


    fun get(): UserEntity? {

        val longId = Hawk.get(PREF_USER_ID, 0L)

        return store
            .select(UserEntity::class.java)
            .where(UserEntity.ID.eq(longId))
            .get()
            .firstOrNull()
    }

    fun put(user: UserEntity): Single<UserEntity> {

        return Single.defer{
            evictAll()

            store.upsert(user)
                .blockingGet()

            return@defer Single.just(user)
        }

    }


    private fun evictAll() {

        store.delete(UserEntity::class.java)
            .get()
            .value()

    }


    fun isCached(): Boolean = store.count(UserEntity::class.java).get().value() > 0

    fun isExpired(): Boolean = false
}