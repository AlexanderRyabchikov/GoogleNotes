package com.client.googlenotes.ui.note.mvp


import com.client.googlenotes.ui.base.AbstractPresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class NotePresenter @Inject constructor(): AbstractPresenter<NoteContract>(), NoteContract.Presenter {
}