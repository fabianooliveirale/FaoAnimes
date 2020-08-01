package com.fabiano.faoanime.requests

import android.util.Log.d
import com.fabiano.faoanime.api.NetworkApi
import com.fabiano.faoanime.models.responses.SearchReponse
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchRequest(
    var value: String,
    var closure: (response: SearchReponse?, error: String?) -> (Unit)
) {

    init {
        try{init()}catch(e: Exception){  d("ObserverTeste_Fabiano", "Error: ${e.message}")}
    }

    private fun init() {
        val observable = NetworkApi.public().search(value)
        observable.subscribeOn(Schedulers.newThread())
            .subscribe(object : Observer<SearchReponse> {
                override fun onComplete() {
                    d("ObserverTeste_Fabiano", "OnComplete")
                }

                override fun onNext(value: SearchReponse?) {
                    closure(value, null)
                }

                override fun onError(e: Throwable?) {
                    closure(null, e?.message)
                }

                override fun onSubscribe(d: Disposable?) {
                    d("ObserverTeste_Fabiano", "onSubscribe")
                }
            })
    }
}