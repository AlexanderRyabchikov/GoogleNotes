package com.client.googlenotes.ui.main

import android.os.Bundle
import com.client.googlenotes.R
import com.client.googlenotes.ui.base.AbstractActivity

class MainActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
