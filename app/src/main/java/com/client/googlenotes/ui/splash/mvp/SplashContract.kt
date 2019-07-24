package com.client.googlenotes.ui.splash.mvp

import com.arellomobile.mvp.MvpView

interface SplashContract {

    interface View : MvpView {
        fun setName(name: String)
    }

    interface Presenter{
        fun onNameRequest()
    }

}