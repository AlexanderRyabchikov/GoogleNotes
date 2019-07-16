package com.client.googlenotes.ui.base

import android.app.AlertDialog
import android.app.ProgressDialog
import android.os.Bundle
import butterknife.BindView
import com.client.googlenotes.R
import com.client.googlenotes.app.App

abstract class AbstractActivity: AbstractBaseActivity(), LoadDataView {


    @BindView(R.id.toolbar) val toolbar: CustomToolbar

    private lateinit var progressDialog: ProgressDialog

    private lateinit var alertDialog: AlertDialog

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        initDialogs()
        getAppComponent().inject(this)
    }

    private fun initDialogs() {
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage(getString(R.string.dialog_loading))
        progressDialog.setCancelable(false)

        alertDialog = AlertDialog.Builder(this)
            .setTitle(getString(R.string.alert_dialog_title))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.alert_dialog_button), null)
            .create()

    }

    override fun onDestroy(){
        super.onDestroy()
        releaseDialogs()
    }

    private fun releaseDialogs() {
        progressDialog.dismiss()
        alertDialog.dismiss()
    }

    protected fun getAppComponent(): AppComponent = ((App)getApplocation).getAppComponent()

    private fun initToolbar() = toolbar?:setupToolbar(toolbar)

    protected fun setupToolbar(toolbar: CustomToolbar) {

    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(resId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}