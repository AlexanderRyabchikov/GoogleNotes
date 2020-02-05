package com.client.googlenotes.data.store.dataStore

import com.client.googlenotes.data.cache.NotesCache
import com.client.googlenotes.data.cache.UserCache
import com.client.googlenotes.data.customException.NoSuchUserException
import com.client.googlenotes.data.database.models.NoteTableEntity
import com.client.googlenotes.data.database.models.UserEntity
import com.client.googlenotes.data.store.notes.NotesDataStore
import com.client.googlenotes.data.store.user.UserDataStore
import io.reactivex.Single
import javax.inject.Inject

class CacheDataStore @Inject constructor(private val noteCache: NotesCache, private val userCache: UserCache) : NotesDataStore, UserDataStore {


    override fun putNote(item: NoteTableEntity): Single<NoteTableEntity> {
        return Single.defer {
            return@defer noteCache
                .put(item)
        }
    }

    override fun putNotes(notes: List<NoteTableEntity>): Single<List<NoteTableEntity>> {
        return Single.defer {
            return@defer noteCache
                .put(notes)
        }
    }


    override fun getNote(id: Long): Single<NoteTableEntity> {
        return Single.defer {
            return@defer noteCache
                .getItem(id)
        }
    }


    override fun getNotes(): Single<List<NoteTableEntity>> {
        return Single.defer {
            return@defer noteCache
                .get()
        }
    }

    override fun getUser(): Single<UserEntity> {

        when (val entity = userCache.get()) {
            null ->  return Single.error(NoSuchUserException())
            else ->  return Single.just(entity)
        }

    }

    override fun putUser(user: UserEntity): Single<UserEntity> {
        return Single.defer {
            return@defer userCache.put(user)
        }
    }

    override fun getUserName(): Single<String> {

        return Single.fromCallable{

            val entity: UserEntity? = userCache.get()
            if (entity == null || entity.getName().isEmpty()) {

                return@fromCallable "Гость"

            } else {
                return@fromCallable entity.getName()
            }

        }
    }
}