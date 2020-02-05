package com.client.googlenotes.ui.splash.mvp

import com.client.googlenotes.ui.base.LoadDataView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(OneExecutionStateStrategy::class)
interface SplashContract :LoadDataView {

    fun setName(name: String)
    fun completeLoading()
    fun openAuthScreen()

    interface Presenter{
        fun onNameRequest()
        fun checkAuthUser()
    }

}