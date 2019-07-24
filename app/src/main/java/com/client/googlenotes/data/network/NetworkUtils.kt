package com.client.googlenotes.data.network

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

final class NetworkUtils @Inject constructor(val context: Context){

    fun isOffline(): Boolean {

        val connectivityManager: ConnectivityManager
                = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return !connectivityManager.activeNetworkInfo.isConnected
    }
}