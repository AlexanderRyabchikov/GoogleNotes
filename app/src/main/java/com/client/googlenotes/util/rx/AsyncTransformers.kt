package com.client.googlenotes.util.rx

import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AsyncTransformers private constructor(){

    companion object{

        fun <T> single() : SingleTransformer<T, T> {
            return SingleTransformer { upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }
        }

    }

}