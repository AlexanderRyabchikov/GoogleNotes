package com.client.googlenotes.ui.note.mvp

import com.arellomobile.mvp.InjectViewState
import com.client.googlenotes.ui.base.AbstractPresenter
import javax.inject.Inject

@InjectViewState
class NotePresenter @Inject constructor(): AbstractPresenter<NoteContract.View>(), NoteContract.Presenter {
}