package com.client.googlenotes.ui.map

import android.os.Bundle
import com.client.googlenotes.R
import com.client.googlenotes.ui.base.AbstractActivity

class MapActivity : AbstractActivity() {
    override fun getLayoutId(): Int = R.layout.activity_map

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
    }
}
