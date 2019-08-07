package com.client.googlenotes.ui.main

import android.app.Activity
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.client.googlenotes.R
import com.client.googlenotes.dagger.core.DaggerActivityCoreComponent
import com.client.googlenotes.ui.base.AbstractActivity
import com.client.googlenotes.ui.main.mvp.MainContract
import com.client.googlenotes.ui.main.mvp.MainPresenter
import javax.inject.Inject

class MainActivity : AbstractActivity(), MainContract.View{

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    override val layoutRes: Int
        get() = R.layout.activity_main

    override val activity: Activity
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
