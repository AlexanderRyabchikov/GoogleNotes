package com.client.googlenotes.ui.base

import com.client.googlenotes.data.dataContainer.BaseDataContainer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter
import moxy.MvpView

abstract class AbstractPresenter<V: MvpView> : MvpPresenter<V>() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected fun subscribe(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    protected fun <T> handlerContainerState(container: BaseDataContainer<T>) {

        if(viewState !is LoadDataView) return

        val loadDataView = viewState as LoadDataView

        when (container.isLoadingContainer()){
            true -> loadDataView.showLoading()
            else -> loadDataView.hideLoading()
        }

        if (container.hasError()){
            handleError(container.getErrorContainer())
        }
    }

    fun handleError(throwable: Throwable?) {
        val loadDataView = viewState as LoadDataView
        loadDataView.showError(throwable?.message)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

}