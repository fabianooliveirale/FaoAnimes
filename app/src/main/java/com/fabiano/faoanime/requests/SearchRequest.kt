package com.fabiano.faoanime.requests

import android.util.Log.d
import com.fabiano.faoanime.api.NetworkApi
import com.fabiano.faoanime.models.responses.SearchReponse
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchRequest(var value: String, var closure: (response: SearchReponse?, error: String?) -> (Unit)) {

    init {
        init()
    }

    private fun init() {
        d("teste", "$value")
        val observable = NetworkApi.public()
        //.search(value)
//        observable.enqueue(object : Callback<SearchReponse> {
//            override fun onFailure(call: Call<SearchReponse>, t: Throwable) {
//                d("ObserverTeste_Fabiano", "onSubscribe ${t.message}")
//            }
//
//            override fun onResponse(call: Call<SearchReponse>, response: Response<SearchReponse>) {
//                d("ObserverTeste_Fabiano", "onSubscribe ${response.body()}")
//            }
//        })
//        observable.subscribeOn(Schedulers.newThread())
//            .subscribe(object : Observer<SearchReponse> {
//                override fun onComplete() {
//                    d("ObserverTeste_Fabiano", "OnComplete")
//                }
//
//                override fun onNext(value: SearchReponse?) {
//                    closure(value, null)
//                }
//
//                override fun onError(e: Throwable?) {
//                    closure(null, e?.message)
//                }
//
//                override fun onSubscribe(d: Disposable?) {
//                    d("ObserverTeste_Fabiano", "onSubscribe")
//                }
//            })
    }
}