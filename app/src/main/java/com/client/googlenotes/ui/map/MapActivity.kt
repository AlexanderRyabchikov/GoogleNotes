package com.client.googlenotes.ui.map

import com.client.googlenotes.R
import com.client.googlenotes.dagger.core.DaggerActivityCoreComponent
import com.client.googlenotes.ui.base.AbstractActivity
import com.client.googlenotes.ui.map.mvp.MapContract
import com.client.googlenotes.ui.map.mvp.MapPresenter
import moxy.presenter.InjectPresenter
import javax.inject.Inject

class MapActivity : AbstractActivity(), MapContract {

    @Inject
    @InjectPresenter
    lateinit var presenter: MapPresenter

    override val layoutRes: Int
        get() = R.layout.activity_map


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
