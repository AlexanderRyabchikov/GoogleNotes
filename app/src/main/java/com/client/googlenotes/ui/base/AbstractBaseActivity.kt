package com.client.googlenotes.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import android.util.Log
import moxy.MvpAppCompatActivity

abstract class AbstractBaseActivity : MvpAppCompatActivity() {

    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?){
        injectDependencies()
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
    }

    protected open fun injectDependencies() {
        Log.d("Notes", "no base implementation for dependencies injection")
    }

}