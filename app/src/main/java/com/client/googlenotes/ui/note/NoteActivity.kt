package com.client.googlenotes.ui.note

import com.client.googlenotes.R
import com.client.googlenotes.dagger.core.DaggerActivityCoreComponent
import com.client.googlenotes.ui.base.AbstractActivity
import com.client.googlenotes.ui.note.mvp.NoteContract
import com.client.googlenotes.ui.note.mvp.NotePresenter
import moxy.presenter.InjectPresenter
import javax.inject.Inject

class NoteActivity : AbstractActivity(), NoteContract {

    @Inject
    @InjectPresenter
    lateinit var presenter: NotePresenter

    override val layoutRes: Int
        get() = R.layout.activity_note

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
