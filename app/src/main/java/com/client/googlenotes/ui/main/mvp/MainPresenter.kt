package com.client.googlenotes.ui.main.mvp

import com.client.googlenotes.ui.base.AbstractPresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(): AbstractPresenter<MainContract>(), MainContract.Presenter {
}