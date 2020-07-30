package com.fabiano.faoanime.api

import com.fabiano.faoanime.BuildConfig
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface NetworkApi {

    companion object Factory {
        fun public(): NetworkApi {
            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val interceptor = Interceptor { chain ->
                try {
                    return@Interceptor chain.proceed(
                        chain.request().newBuilder()
                            .addHeader("Content-Type", "application/json")
                            .build()
                    )
                } catch (x: Throwable) {
                    throw x
                }
            }


            val httpCliente = HttpClientBuilderFactory.create(interceptor)

            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.URLAPI)
                .client(httpCliente)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(NetworkApi::class.java)
        }
    }
}