package com.fabiano.faoanime.requests.animes

import android.util.Log.d
import com.fabiano.faoanime.api.NetworkApi
import com.fabiano.faoanime.models.Anime
import com.fabiano.faoanime.models.responses.SearchReponse
import com.fabiano.faoanime.utils.Filter
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchAnimeRequest(
    var value: String,
    var page: Int,
    var closure: (response: ArrayList<Anime>?, error: String?) -> (Unit)
) {
    init {
        try {
            init()
        } catch (e: Exception) {
            val error = "SearchError_1: ${e.message}"
            d("Error_Log_D", error)
            closure(null, error)
        }
    }

    private fun init() {
        val observable = NetworkApi.public().searchAnime(value, page)
        observable.subscribeOn(Schedulers.newThread())
            .subscribe(object : Observer<SearchReponse> {
                override fun onComplete() {}
                override fun onNext(value: SearchReponse?) {
                    val filter = Filter()
                    val newList = value?.results?.filter { filter.animeWithEpisode(it) }
                    closure(ArrayList(newList ?: arrayListOf()), null)
                }

                override fun onError(e: Throwable?) {
                    val error = "SearchError_2: ${e?.message}"
                    d("Error_Log_D", error)
                    closure(null, error)
                }

                override fun onSubscribe(d: Disposable?) {}
            })
    }
}