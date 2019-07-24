package com.client.googlenotes.ui.main.mvp

import com.arellomobile.mvp.InjectViewState
import com.client.googlenotes.ui.base.AbstractPresenter

@InjectViewState
class MainPresenter : AbstractPresenter<MainContract.View>(), MainContract.Presenter {
}