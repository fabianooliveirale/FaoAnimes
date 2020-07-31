package com.fabiano.faoanime.api

import com.fabiano.faoanime.BuildConfig
import io.reactivex.rxjava3.core.Observable
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface NetworkApi {
    @GET("/anime/search/anime{seachString}")
    fun search(
        @Query("q") seachString: String
    ): Observable<String>

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
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(NetworkApi::class.java)
        }
    }
}