package com.fabiano.faoanime.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class HttpClientBuilderFactory {
    companion object {
        private var okHttpClient: OkHttpClient.Builder? = null

        fun create(headintercepter: Interceptor, followRedirects: Boolean = false): OkHttpClient {
            if (okHttpClient == null){
                okHttpClient = OkHttpClient().newBuilder()
            }

            return okHttpClient?.connectTimeout(6000, TimeUnit.MILLISECONDS)
                ?.readTimeout((1000 * 60).toLong(), TimeUnit.MILLISECONDS)
                ?.writeTimeout((1000 * 60).toLong(), TimeUnit.MILLISECONDS)
                ?.followRedirects(followRedirects)
//                ?.addInterceptor(logInterceptor)
                ?.cache(null)
                ?.addInterceptor(headintercepter)
                ?.build() ?: OkHttpClient().newBuilder().build()
        }
    }
}