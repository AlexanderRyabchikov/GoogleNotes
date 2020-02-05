package com.client.googlenotes.ui.splash

import android.content.Intent
import com.client.googlenotes.R
import com.client.googlenotes.ui.base.AbstractActivity
import com.client.googlenotes.ui.base.BaseRouter
import com.client.googlenotes.ui.login.LoginActivity
import com.client.googlenotes.ui.main.MainActivity
import javax.inject.Inject

class SplashRouter @Inject constructor(private val activity: AbstractActivity) : BaseRouter(activity) {

    fun startMainActivity(){

        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
        activity.overridePendingTransition(R.anim.slidein, R.anim.slideout)
        activity.finish()

    }

    fun startLoginActivity() {
        val intent = Intent(activity, LoginActivity::class.java)
        activity.startActivity(intent)
        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        activity.finish()
    }
}