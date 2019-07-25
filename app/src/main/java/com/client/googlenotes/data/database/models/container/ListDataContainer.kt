package com.client.googlenotes.data.database.models.container

import com.client.googlenotes.data.dataContainer.BaseDataContainer

class ListDataContainer<T>(data: List<T>?, loading: Boolean, throwable: Throwable?)
    : BaseDataContainer<List<T>>(data, throwable, loading) {

    constructor(data: List<T>) : this(data, false, null)
    constructor(loading: Boolean) : this(null, loading, null)
    constructor(throwable: Throwable) : this(null, false, throwable)
}