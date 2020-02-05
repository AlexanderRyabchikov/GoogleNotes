package com.client.googlenotes.ui.login.mvp

import com.client.googlenotes.ui.base.AbstractPresenter
import com.client.googlenotes.ui.base.LoadDataView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class LoginPresenter @Inject constructor(): AbstractPresenter<LoginContract>(), LoginContract.Presenter{
}