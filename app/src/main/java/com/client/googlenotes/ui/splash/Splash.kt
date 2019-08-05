package com.client.googlenotes.ui.splash

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.client.googlenotes.R
import com.client.googlenotes.dagger.core.DaggerActivityCoreComponent
import com.client.googlenotes.ui.base.AbstractActivity
import com.client.googlenotes.ui.splash.mvp.SplashContract
import com.client.googlenotes.ui.splash.mvp.SplashPresenter
import javax.inject.Inject
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.view.*
import java.util.*

class Splash : AbstractActivity(), SplashContract.View {

    @Inject
    @InjectPresenter
    lateinit var presenter: SplashPresenter

    private val handler = Handler()
    private val imageShowRunnable: () -> Unit = this::showLogo

    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun getCurrentActivity(): Activity {
        return this
    }


    @ProvidePresenter
    fun providePresenter(): SplashPresenter = presenter

    override fun injectDependencies(){
        super.injectDependencies()
        DaggerActivityCoreComponent
            .builder()
            .appComponent(getAppComponent())
            .activityModule(getActivityModule())
            .build()
            .inject(this)
    }

    private fun showLogo() {
        val anim = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)

        viewElement().background_view.visibility = View.VISIBLE
        viewElement().background_view.animation = anim
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter.onNameRequest()
    }


    override fun setName(name: String) {

        viewElement().splash_greeting.text = when (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
            in 4..11 -> getString(R.string.splash_greeting_user_morning, name)
            in 12..17 -> getString(R.string.splash_greeting_user_day, name)
            in 18..23 -> getString(R.string.splash_greeting_user_evening, name)
            else -> getString(R.string.splash_greeting_user_night, name)
        }
    }


    public override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus) {
            handler.post(imageShowRunnable)
        }
    }
}
