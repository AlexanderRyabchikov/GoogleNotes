package com.client.googlenotes.ui.login

import android.os.Bundle
import com.client.googlenotes.R
import com.client.googlenotes.dagger.core.DaggerActivityCoreComponent
import com.client.googlenotes.ui.base.AbstractActivity

class LoginActivity : AbstractActivity() {
    override fun getLayoutId(): Int = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun injectDependencies(){
        super.injectDependencies()
        DaggerActivityCoreComponent
            .builder()
            .appComponent(getAppComponent())
            .activityModule(getActivityModule())
            .build()
            .inject(this)
    }
}
