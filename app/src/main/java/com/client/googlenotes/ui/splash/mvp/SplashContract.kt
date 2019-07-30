package com.client.googlenotes.ui.splash.mvp

import com.client.googlenotes.ui.base.LoadDataView

interface SplashContract {

    interface View : LoadDataView {
        fun setName(name: String)
    }

    interface Presenter{
        fun onNameRequest()
    }

}