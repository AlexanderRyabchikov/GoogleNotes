package com.client.googlenotes.ui.main.mvp

import com.arellomobile.mvp.InjectViewState
import com.client.googlenotes.ui.base.AbstractPresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(): AbstractPresenter<MainContract.View>(), MainContract.Presenter {
}