package com.client.googlenotes.ui.login.mvp

import com.arellomobile.mvp.InjectViewState
import com.client.googlenotes.ui.base.AbstractPresenter
import javax.inject.Inject

@InjectViewState
class LoginPresenter @Inject constructor(): AbstractPresenter<LoginContract.View>(), LoginContract.Presenter {
}