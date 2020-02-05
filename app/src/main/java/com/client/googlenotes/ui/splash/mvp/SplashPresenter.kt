package com.client.googlenotes.ui.splash.mvp

import com.client.googlenotes.app.SPLASH_DEFAULT_DURATION
import com.client.googlenotes.data.customException.NoSuchUserException
import com.client.googlenotes.data.repositories.user.UserRepository
import com.client.googlenotes.ui.base.AbstractPresenter
import com.client.googlenotes.util.rx.single
import io.reactivex.Single
import moxy.InjectViewState
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class SplashPresenter @Inject constructor(private val userRepository: UserRepository)
    : AbstractPresenter<SplashContract>(), SplashContract.Presenter {

    override fun onNameRequest() {

        subscribe(
            userRepository
                .getUserName()
                .compose(single())
                .doOnError { handleError(it) }
                .subscribe { name -> viewState.setName(name) })

    }

    override fun checkAuthUser() {

        subscribe(Single
            .timer(SPLASH_DEFAULT_DURATION, TimeUnit.MILLISECONDS)
            .subscribe ({
                subscribe(userRepository
                    .getUser()
                    .compose(single())
                    .doOnSuccess { viewState.completeLoading() }
                    .subscribe({}, this::checkAuthUserError))

            }, {
                this::checkAuthUserError
            }))
    }

    private fun checkAuthUserError(e: Throwable) {

       if (e is NoSuchUserException) {
           viewState.openAuthScreen()
       } else {
           handleError(e)
       }

    }
}