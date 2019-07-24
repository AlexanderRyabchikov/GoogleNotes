package com.client.googlenotes.data.dataContainer

class BaseDataContainer<T>(private val data: T?, private val error: Throwable?, private val loading: Boolean) : DataContainer<T> {

    override fun getDataContainer(): T? = data

    override fun getErrorContainer(): Throwable? = error

    override fun isLoadingContainer(): Boolean = loading


    fun hasData(): Boolean = data != null
    fun hasError(): Boolean = error != null

    constructor(data: T): this(data, null, false)

    constructor(loading: Boolean): this(null, null, loading)

    constructor(error: Throwable): this(null, error, false)

}