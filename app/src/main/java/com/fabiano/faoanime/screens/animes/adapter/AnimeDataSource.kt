package com.fabiano.faoanime.screens.animes.adapter

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.fabiano.faoanime.interfaces.ResponseInterface
import com.fabiano.faoanime.models.Anime
import com.fabiano.faoanime.requests.SearchRequest
import com.fabiano.faoanime.screens.animes.AnimesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

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
            if (stringSearch == "") return@launch
            val page = 1
            responseInterface.loading()
            SearchRequest(stringSearch, page) { value, error ->
                if (value != null) {
                    callback.onResult(value.results ?: arrayListOf(), null, page)
                }
                if (error != null) {
                    responseInterface.error(error)
                }
                responseInterface.dismissLoading()
            }
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Anime>
    ) {
        viewModel.launch {
            if (stringSearch == "") return@launch
            val page = params.key + 1
            responseInterface.afterLoading()
            SearchRequest(stringSearch, page) { value, error ->
                if (value != null) {
                    callback.onResult(value.results ?: arrayListOf(), page)
                }
                if (error != null) {
                    responseInterface.error(error)
                }
                responseInterface.dismissLoading()
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Anime>
    ) {
        viewModel.launch {
            if (stringSearch == "") return@launch
            val page = params.key - 1
            responseInterface.loading()
            SearchRequest(stringSearch, page) { value, error ->
                if (value != null) {
                    callback.onResult(value.results ?: arrayListOf(), page)
                }
                if (error != null) {
                    responseInterface.error(error)
                }
                responseInterface.dismissLoading()
            }
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

