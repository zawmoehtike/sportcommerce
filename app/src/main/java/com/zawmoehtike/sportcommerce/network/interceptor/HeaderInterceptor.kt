package com.zawmoehtike.sportcommerce.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import javax.inject.Inject

class HeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val originalHeader = request.headers
        val headerBuilder = originalHeader.newBuilder()
        headerBuilder.add("Content-Type", "application/json")
        headerBuilder.add("Accept", "application/json")
        headerBuilder.add("X-Requested-With", "XMLHttpRequest")
        //one way to fix java.net.ProtocolException: Unexectped status line:
        headerBuilder.add("Connection", "close")
        headerBuilder.add("X-RESPONSE-ENCRYPTED", "0")

        val newRequest = request.newBuilder().headers(headerBuilder.build()).build()
        val response = chain.proceed(newRequest)

        Timber.i(response.toString())

        return response
    }
}