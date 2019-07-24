package com.client.googlenotes.ui.map.mvp

import com.arellomobile.mvp.InjectViewState
import com.client.googlenotes.ui.base.AbstractPresenter
import javax.inject.Inject

@InjectViewState
class MapPresenter @Inject constructor(): AbstractPresenter<MapContract.View>(), MapContract.Presenter {
}