package com.client.googlenotes.data.cache

import com.client.googlenotes.data.database.models.NoteTableEntity
import io.reactivex.Single
import io.requery.Persistable
import io.requery.reactivex.ReactiveEntityStore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotesCache @Inject constructor(private val store: ReactiveEntityStore<Persistable>){

    fun getItem(id: Long): Single<NoteTableEntity> {
        return store
            .select(NoteTableEntity::class.java)
            .where(NoteTableEntity.ID.eq(id))
            .get()
            .observable()
            .firstOrError()
    }

    fun get(): Single<List<NoteTableEntity>>{
        return store
            .select(NoteTableEntity::class.java)
            .orderBy(NoteTableEntity.ID.desc())
            .get()
            .observable()
            .toList()
    }


    fun put(notes: List<NoteTableEntity>): Single<List<NoteTableEntity>>{

        return Single.defer {

            evictAll()

            store.upsert(notes)
                .blockingGet()

            return@defer get()
        }

    }

    fun put(note: NoteTableEntity): Single<NoteTableEntity>{

        return Single.defer{
            evictAll()

            store.upsert(note)
                .blockingGet()

            return@defer Single.just(note)
        }

    }

    private fun evictAll() {

        store.delete(NoteTableEntity::class.java)
            .get()
            .value()

    }


    fun isCached(): Boolean = store.count(NoteTableEntity::class.java).get().value() > 0

    fun isExpired(): Boolean = false

}