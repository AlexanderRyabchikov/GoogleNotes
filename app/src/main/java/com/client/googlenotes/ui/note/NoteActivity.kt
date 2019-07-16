package com.client.googlenotes.ui.note

import android.os.Bundle
import com.client.googlenotes.R
import com.client.googlenotes.ui.base.AbstractActivity

class NoteActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
    }
}
