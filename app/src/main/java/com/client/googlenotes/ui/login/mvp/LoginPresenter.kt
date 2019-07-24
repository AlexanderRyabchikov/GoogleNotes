package com.client.googlenotes.ui.login.mvp

import com.arellomobile.mvp.InjectViewState
import com.client.googlenotes.ui.base.AbstractPresenter

@InjectViewState
class LoginPresenter: AbstractPresenter<LoginContract.View>(), LoginContract.Presenter {
}