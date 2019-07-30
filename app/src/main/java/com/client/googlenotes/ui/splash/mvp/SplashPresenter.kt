package com.client.googlenotes.ui.splash.mvp

import com.arellomobile.mvp.InjectViewState
import com.client.googlenotes.data.mappers.UserEntityToDisplayMapper
import com.client.googlenotes.data.repositories.user.UserRepository
import com.client.googlenotes.ui.base.AbstractPresenter
import com.client.googlenotes.util.rx.AsyncTransformers
import javax.inject.Inject

@InjectViewState
class SplashPresenter @Inject constructor(private val userRepository: UserRepository,
                                          private val mapper: UserEntityToDisplayMapper)
    : AbstractPresenter<SplashContract.View>(), SplashContract.Presenter {

    override fun onNameRequest() {

        subscribe(
            userRepository
                .getUser()
                .map(mapper::map)
                .compose(AsyncTransformers.single())
                .doOnSubscribe { viewState.showLoading() }
                .doFinally { viewState.hideLoading() }
                .subscribe({display ->
                    viewState.setName(display.name)
                }, this::handleError))
    }
}