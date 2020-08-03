package com.fabiano.faoanime.screens.animes.adapter

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.fabiano.faoanime.interfaces.ResponseInterface
import com.fabiano.faoanime.models.Anime
import com.fabiano.faoanime.requests.animes.GetAnimeOfTheSeasonRequest
import com.fabiano.faoanime.requests.animes.SearchAnimeRequest
import com.fabiano.faoanime.screens.animes.AnimesViewModel
import kotlinx.coroutines.launch

class AnimeDataSource(
    private val responseInterface: ResponseInterface,
    val viewModel: AnimesViewModel
) :
    PageKeyedDataSource<Int, Anime>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Anime>
    ) {
        viewModel.launch {
            if (stringSearch == "") {
                getSeasonAnime(callbackInital = callback)
            } else {
                searchedAnime(callbackInital = callback)
            }
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Anime>
    ) {
        viewModel.launch {
            if (stringSearch == "") {
                getSeasonAnime(callback)
            } else {
                val page = params.key + 1
                searchedAnime(callback, page = page)
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Anime>
    ) {
        viewModel.launch {
            if (stringSearch == "") {
                getSeasonAnime(callback)
            } else {
                val page = params.key - 1
                searchedAnime(callback, page = page)
            }
        }
    }

    private fun getSeasonAnime(
        callback: LoadCallback<Int, Anime>? = null,
        callbackInital: LoadInitialCallback<Int, Anime>? = null
    ) {
        responseInterface.loading()
        GetAnimeOfTheSeasonRequest { value, error ->
            if (value != null) {
                callbackInital?.onResult(value, null, null)
                callback?.onResult(value, null)
            }
            if (error != null) {
                responseInterface.error(error)
            }
            responseInterface.dismissLoading()
        }
    }

    private fun searchedAnime(
        callback: LoadCallback<Int, Anime>? = null,
        callbackInital: LoadInitialCallback<Int, Anime>? = null,
        page: Int = 1
    ) {
        responseInterface.loading()
        SearchAnimeRequest(
            stringSearch,
            page
        ) { value, error ->
            if (value != null) {
                callbackInital?.onResult(value, null, page)
                callback?.onResult(value, page)
            }
            if (error != null) {
                responseInterface.error(error)
            }
            responseInterface.dismissLoading()
        }
    }

    companion object {
        var stringSearch = ""

        class DataSourceFactory(
            private val responseInterface: ResponseInterface,
            val viewModel: AnimesViewModel
        ) :
            DataSource.Factory<Int, Anime>() {
            override fun create(): DataSource<Int, Anime> =
                AnimeDataSource(responseInterface, viewModel)
        }
    }
}

