package com.fabiano.faoanime.requests.animes

import android.util.Log.d
import com.fabiano.faoanime.api.NetworkApi
import com.fabiano.faoanime.models.Anime
import com.fabiano.faoanime.models.responses.SeasonReponse
import com.fabiano.faoanime.utils.Filter
import com.fabiano.faoanime.utils.Formatter
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.joda.time.DateTime

class GetAnimeOfTheSeasonRequest(
    var closure: (response: ArrayList<Anime>?, error: String?) -> (Unit)
) {
    init {
        try {
            init()
        } catch (e: Exception) {
            val error = "GetAnimeOfTheSeasonRequest_1: ${e.message}"
            d("Error_Log_D", error)
            closure(null, error)
        }
    }

    private fun init() {
        val timeNow = DateTime.now()
        val season = Formatter().parseDateTimeToSeason(timeNow)
        val observable =
            NetworkApi.public().getAnimeOfTheSeason(season.year ?: 0, season.name ?: "")
        observable.subscribeOn(Schedulers.newThread())
            .subscribe(object : Observer<SeasonReponse> {
                override fun onComplete() {}

                override fun onNext(value: SeasonReponse?) {
                    val filter = Filter()
                    val newList = value?.results?.filter { filter.animeWithEpisode(it) }
                    closure(ArrayList(newList ?: arrayListOf()), null)
                }

                override fun onError(e: Throwable?) {
                    val error = "GetAnimeOfTheSeasonRequest_2: ${e?.message}"
                    d("Error_Log_D", error)
                    closure(null, error)
                }

                override fun onSubscribe(d: Disposable?) {}
            })
    }
}