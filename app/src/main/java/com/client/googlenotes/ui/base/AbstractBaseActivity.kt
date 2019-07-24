package com.client.googlenotes.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.util.Log
import butterknife.ButterKnife
import com.arellomobile.mvp.MvpAppCompatActivity

abstract class AbstractBaseActivity : MvpAppCompatActivity() {


    protected override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        injectDependencies()
        setContentView(getLayoutId())
    }

    override fun onContentChanged(){
        super.onContentChanged()
        ButterKnife.bind(this)
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected open fun injectDependencies() {
        Log.d("Notes", "no base implementation for dependencies injection")
    }

}