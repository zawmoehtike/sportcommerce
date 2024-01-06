package com.zawmoehtike.sportcommerce.network

import com.zawmoehtike.sportcommerce.network.exception.NetworkException
import com.zawmoehtike.sportcommerce.network.exception.NoContentException
import retrofit2.Call
import retrofit2.Response

/**
 * Created by Vincent on 2019-10-21
 */
private const val KEY_CONTENT = 204
private const val ERROR_401 = 401

fun <T> Call<T>.executeOrThrow(): T {
    val response = this.execute()
    return response.getBodyOrThrowNetworkException()
}

fun <T> Response<T>.getBodyOrThrowNetworkException(): T {
    if (this.isSuccessful.not()) {
        val errorString = this.errorBody()!!.byteStream().bufferedReader().use { it.readText() }
        if (this.raw().code == ERROR_401) {
            //for alternate usage of local broadcast manager
//            val localIntent = Intent("action_to_logout")
//                .putExtra("message", "401")
//            localBroadcastManager.sendBroadcast(localIntent)
            throw NetworkException(errorString, this.raw().code)
        } else {
            throw NetworkException(errorString, this.code())
        }
    }
    if (this.code() == KEY_CONTENT) {
        throw NoContentException()
    }
    val body = this.body() ?: throw NetworkException()

    return body
}