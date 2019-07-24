package com.client.googlenotes.ui.base

import android.support.annotation.StringRes

interface LoadDataView {

    fun showLoading()

    fun hideLoading()

    fun showError(error: String?)

    fun showError(@StringRes resId: Int)
}