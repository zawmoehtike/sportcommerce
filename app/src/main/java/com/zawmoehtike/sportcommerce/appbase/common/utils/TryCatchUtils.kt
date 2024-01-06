package com.zawmoehtike.sportcommerce.appbase.common.utils

import android.util.Log

object TryCatchUtils {

    suspend fun tryInSilentSuspend(func: suspend () -> Unit) {
        try {
            func.invoke()
        } catch (e: Exception) {
            Log.d("TryCatchUtil", "error: ${e.localizedMessage}")
        }
    }

    fun tryInSilent(func: () -> Unit) {
        try {
            func.invoke()
        } catch (e: Exception) {
            Log.d("TryCatchUtil", "error: ${e.localizedMessage}")
        }
    }
}