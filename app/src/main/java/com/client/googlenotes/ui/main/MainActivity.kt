package com.client.googlenotes.ui.main

import com.client.googlenotes.R
import com.client.googlenotes.dagger.core.DaggerActivityCoreComponent
import com.client.googlenotes.ui.base.AbstractActivity
import com.client.googlenotes.ui.main.mvp.MainContract
import com.client.googlenotes.ui.main.mvp.MainPresenter
import moxy.presenter.InjectPresenter
import javax.inject.Inject

class MainActivity : AbstractActivity(), MainContract {

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    override val layoutRes: Int
        get() = R.layout.activity_main

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
