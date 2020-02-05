package com.client.googlenotes.ui.map.mvp

import com.client.googlenotes.ui.base.AbstractPresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class MapPresenter @Inject constructor(): AbstractPresenter<MapContract>(), MapContract.Presenter {
}