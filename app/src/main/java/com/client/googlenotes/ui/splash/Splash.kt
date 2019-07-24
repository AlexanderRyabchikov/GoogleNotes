package com.client.googlenotes.ui.splash

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.client.googlenotes.R
import com.client.googlenotes.dagger.core.DaggerActivityCoreComponent
import com.client.googlenotes.ui.base.AbstractActivity
import com.client.googlenotes.ui.core.DaggerActivityComponent
import com.client.googlenotes.ui.splash.mvp.SplashContract
import com.client.googlenotes.ui.splash.mvp.SplashPresenter
import javax.inject.Inject

class Splash : AbstractActivity(), SplashContract.View {


    @Inject
    @InjectPresenter
    lateinit var presenter: SplashPresenter

    override fun getLayoutId(): Int = R.layout.activity_splash

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
        setContentView(R.layout.activity_splash)
    }


    override fun setName(name: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
