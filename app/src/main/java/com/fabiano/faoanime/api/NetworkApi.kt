package com.fabiano.faoanime.api

import com.fabiano.faoanime.BuildConfig
import com.fabiano.faoanime.models.responses.SearchReponse
import com.fabiano.faoanime.models.responses.SeasonReponse
import io.reactivex.rxjava3.core.Observable
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface NetworkApi {
    @GET("search/anime")
    fun searchAnime(
        @Query("q") seachString: String,
        @Query("page") page: Int,
        @Query("rated") rateOne: String = "g",
        @Query("rated") rateTwo: String = "pg",
        @Query("rated") rateThree: String = "pg13",
        @Query("rated") rateFour: String = "r"
    ): Observable<SearchReponse>

    @GET("season/{year}/{season}")
    fun getAnimeOfTheSeason(
        @Path("year") year: Int,
        @Path("season") season: String
    ): Observable<SeasonReponse>

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

            val httpCliente = HttpClientBuilderFactory.create(interceptor, logInterceptor = logInterceptor)

            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.URLAPI)
                .client(httpCliente)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(NetworkApi::class.java)
        }
    }
}