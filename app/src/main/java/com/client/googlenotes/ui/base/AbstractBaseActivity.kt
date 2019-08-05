package com.client.googlenotes.ui.base

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.util.Log
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity

abstract class AbstractBaseActivity : MvpAppCompatActivity() {

    private lateinit var binding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        injectDependencies()
        setContentView(getLayoutId())
    }

    override fun onContentChanged(){
        super.onContentChanged()

        binding = DataBindingUtil.setContentView(getCurrentActivity(), getLayoutId())

    }

    protected fun viewElement(): View = binding.root

    protected abstract fun getCurrentActivity(): Activity

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected open fun injectDependencies() {
        Log.d("Notes", "no base implementation for dependencies injection")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

}