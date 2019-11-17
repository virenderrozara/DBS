package com.dbs.utils

import android.content.Context
import android.net.ConnectivityManager



object NetworkUtils {
    /**
     * Checking Internet Connectivity both WIFI and Mobile
     */
    fun isNetworkConnected(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
