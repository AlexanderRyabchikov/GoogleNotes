package com.client.googlenotes.ui.map

import android.app.Activity
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.client.googlenotes.R
import com.client.googlenotes.dagger.core.DaggerActivityCoreComponent
import com.client.googlenotes.ui.base.AbstractActivity
import com.client.googlenotes.ui.map.mvp.MapContract
import com.client.googlenotes.ui.map.mvp.MapPresenter
import javax.inject.Inject

class MapActivity : AbstractActivity(), MapContract.View {

    @Inject
    @InjectPresenter
    lateinit var presenter: MapPresenter

    override val layoutRes: Int
        get() = R.layout.activity_map

    override val activity: Activity
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
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
