package com.client.googlenotes.ui.base

import android.app.AlertDialog
import android.app.ProgressDialog
import android.os.Bundle
import com.client.googlenotes.R
import com.client.googlenotes.app.App
import com.client.googlenotes.dagger.core.AppComponent
import com.client.googlenotes.ui.core.ActivityModule

abstract class AbstractActivity: AbstractBaseActivity(), LoadDataView {


    //@BindView(R.id.toolbar) val toolbar: CustomToolbar

    private lateinit var progressDialog: ProgressDialog

    private lateinit var alertDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initToolbar()
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

    protected fun getAppComponent(): AppComponent = (application as App).getAppComponent()

   /* private fun initToolbar() = toolbar?:setupToolbar(toolbar)

    protected fun setupToolbar(toolbar: CustomToolbar) {

    }*/

    protected fun showErrorDialog(message: String?){
        alertDialog.setMessage(message)
        alertDialog.show()
    }

    protected fun showErrorDialog(resId: Int){
        showErrorDialog(getString(resId))
    }

    fun showLoadingDialog(){
        if (!progressDialog.isShowing){
            progressDialog.show()
        }
    }

    fun hideLoadingDialog(){
        if (progressDialog.isShowing){
            progressDialog.dismiss()
        }
    }

    override fun showLoading() {
        showLoadingDialog()
    }

    override fun hideLoading() {
        hideLoadingDialog()
    }

    override fun showError(error: String?) {
        showErrorDialog(error)
    }

    override fun showError(resId: Int) {
        showErrorDialog(resId)
    }

    protected fun getActivityModule(): ActivityModule = ActivityModule(this)
}