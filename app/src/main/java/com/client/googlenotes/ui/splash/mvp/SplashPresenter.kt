package com.client.googlenotes.ui.splash.mvp

import com.arellomobile.mvp.InjectViewState
import com.client.googlenotes.ui.base.AbstractPresenter
import javax.inject.Inject

@InjectViewState
class SplashPresenter @Inject constructor(): AbstractPresenter<SplashContract.View>(), SplashContract.Presenter {

    override fun onNameRequest() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}