package com.client.googlenotes.ui.base

open class BaseRouter constructor(val abstractActivity: AbstractActivity){

    fun back() { abstractActivity.onBackPressed() }
}