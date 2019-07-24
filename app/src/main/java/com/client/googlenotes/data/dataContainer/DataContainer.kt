package com.client.googlenotes.data.dataContainer

interface DataContainer<T> {

    fun getDataContainer():T?
    fun getErrorContainer(): Throwable?
    fun isLoadingContainer(): Boolean
}