package com.client.googlenotes.ui.splash

import android.os.Bundle
import com.client.googlenotes.R
import com.client.googlenotes.ui.base.AbstractActivity

class Splash : AbstractActivity() {
    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}
