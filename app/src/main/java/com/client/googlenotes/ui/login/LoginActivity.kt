package com.client.googlenotes.ui.login

import android.app.Activity
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.client.googlenotes.R
import com.client.googlenotes.dagger.core.DaggerActivityCoreComponent
import com.client.googlenotes.ui.base.AbstractActivity
import com.client.googlenotes.ui.login.mvp.LoginContract
import com.client.googlenotes.ui.login.mvp.LoginPresenter
import javax.inject.Inject

class LoginActivity : AbstractActivity(), LoginContract.View {

    @Inject
    @InjectPresenter
    lateinit var presenter: LoginPresenter

    override fun getLayoutId(): Int = R.layout.activity_login

    override fun getCurrentActivity(): Activity  = this

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
