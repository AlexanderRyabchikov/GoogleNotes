package com.client.googlenotes.ui.login

import android.os.Bundle
import com.client.googlenotes.R
import com.client.googlenotes.dagger.core.DaggerActivityCoreComponent
import com.client.googlenotes.ui.base.AbstractActivity
import com.client.googlenotes.ui.login.mvp.LoginContract
import com.client.googlenotes.ui.login.mvp.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import moxy.presenter.InjectPresenter
import javax.inject.Inject

class LoginActivity : AbstractActivity(), LoginContract{

    @Inject
    @InjectPresenter
    lateinit var presenter: LoginPresenter

    override val layoutRes: Int
        get() = R.layout.activity_login

    override fun injectDependencies(){
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

        buttonLogin.setOnClickListener{
            buttonLogin.showProgress()
            buttonLogin.isEnabled = false
        }

    }
}
