package com.client.googlenotes.ui.note.mvp

import com.arellomobile.mvp.InjectViewState
import com.client.googlenotes.ui.base.AbstractPresenter

@InjectViewState
class NotePresenter : AbstractPresenter<NoteContract.View>(), NoteContract.Presenter {
}