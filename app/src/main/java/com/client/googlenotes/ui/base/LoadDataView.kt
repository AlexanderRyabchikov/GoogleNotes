package com.client.googlenotes.ui.base

import android.support.annotation.StringRes
import com.arellomobile.mvp.MvpView

interface LoadDataView : MvpView {

    fun showLoading()

    fun hideLoading()

    fun showError(error: String?)

    fun showError(@StringRes resId: Int)
}