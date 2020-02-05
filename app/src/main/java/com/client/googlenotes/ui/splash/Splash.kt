package com.client.googlenotes.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.client.googlenotes.R
import com.client.googlenotes.dagger.core.DaggerActivityCoreComponent
import com.client.googlenotes.ui.base.AbstractActivity
import com.client.googlenotes.ui.extension.show
import com.client.googlenotes.ui.splash.mvp.SplashContract
import com.client.googlenotes.ui.splash.mvp.SplashPresenter
import kotlinx.android.synthetic.main.activity_splash.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import java.util.*
import javax.inject.Inject

class Splash : AbstractActivity(), SplashContract {

    private val handler = Handler()
    private val logoShowRunnable: () -> Unit = this::showLogo

    @Inject
    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @Inject
    lateinit var router: SplashRouter

    override val layoutRes: Int
        get() = R.layout.activity_splash


    @ProvidePresenter
    fun providePresenter(): SplashPresenter = presenter

    override fun injectDependencies() {
        super.injectDependencies()
        DaggerActivityCoreComponent
            .builder()
            .appComponent(getAppComponent())
            .activityModule(getActivityModule())
            .build()
            .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.onNameRequest()
        presenter.checkAuthUser()
    }

    override fun setName(name: String) {

        splash_greeting.text = when (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
            in 4..11 -> getString(R.string.splash_greeting_user_morning, name)
            in 12..17 -> getString(R.string.splash_greeting_user_day, name)
            in 18..23 -> getString(R.string.splash_greeting_user_evening, name)
            else -> getString(R.string.splash_greeting_user_night, name)
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            handler.post(logoShowRunnable)
        }

    }

    private fun showLogo() {
        val anim = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        background_view.show()
        background_view.animation = anim
        splash_greeting.show()
        splash_greeting.animation = anim
    }

    override fun completeLoading() {
        router.startMainActivity()
    }

    override fun openAuthScreen() {
        router.startLoginActivity()
    }
}
