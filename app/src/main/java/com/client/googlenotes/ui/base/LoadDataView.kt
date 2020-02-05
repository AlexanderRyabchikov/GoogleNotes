package com.client.googlenotes.ui.base

import androidx.annotation.StringRes
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(OneExecutionStateStrategy::class)
interface LoadDataView : MvpView {

    fun showLoading()

    fun hideLoading()

    fun showError(error: String?)

    fun showError(@StringRes resId: Int)
}