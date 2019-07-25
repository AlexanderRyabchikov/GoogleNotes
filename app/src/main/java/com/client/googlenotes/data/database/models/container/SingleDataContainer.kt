package com.client.googlenotes.data.database.models.container

import com.client.googlenotes.data.dataContainer.BaseDataContainer
import com.client.googlenotes.data.network.NoConnectivityException
import io.reactivex.Observable
import io.reactivex.Single


class SingleDataContainer<T> (val data: T?, var loading: Boolean, var throwable: Throwable?)
    : BaseDataContainer<T>(data, throwable, loading) {

    constructor(data: T) : this(data, false, null)
    constructor(loading: Boolean) : this(null, loading, null)
    constructor(throwable: Throwable) : this(null, false, throwable)

    fun addLoading(): SingleDataContainer<T> {

        loading = true
        return this

    }

    fun addError(throwable: Throwable): SingleDataContainer<T> {
        this.throwable = throwable
        return this
    }

    private fun <T> createLoading(): SingleDataContainer<T> {
        return SingleDataContainer(true)
    }

    private fun <T> createError(throwable: Throwable): SingleDataContainer<T> {
        return SingleDataContainer(throwable)
    }

    fun <T> loading(): Single<SingleDataContainer<T>> {
        return Single.just(createLoading())
    }

    fun <T> errorSingle(throwable: Throwable): Single<SingleDataContainer<T>> {
        return Single.just(createError(throwable))
    }

    fun <T> errorObservable(throwable: Throwable): Observable<SingleDataContainer<T>> {
        return Observable.just(createError(throwable))
    }

    fun <T> noConnectivitySingle(): Single<SingleDataContainer<T>> {
        return errorSingle(NoConnectivityException())
    }

    fun <T> noConnectivityObservable(): Observable<SingleDataContainer<T>> {
        return errorObservable(NoConnectivityException())
    }
}

