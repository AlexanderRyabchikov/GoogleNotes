package com.client.googlenotes.ui.note

import android.app.Activity
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.client.googlenotes.R
import com.client.googlenotes.dagger.core.DaggerActivityCoreComponent
import com.client.googlenotes.ui.base.AbstractActivity
import com.client.googlenotes.ui.note.mvp.NoteContract
import com.client.googlenotes.ui.note.mvp.NotePresenter
import javax.inject.Inject

class NoteActivity : AbstractActivity(), NoteContract.View {

    @Inject
    @InjectPresenter
    lateinit var presenter: NotePresenter

    override val layoutRes: Int
        get() = R.layout.activity_note

    override val activity: Activity
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
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
