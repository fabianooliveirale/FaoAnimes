package com.fabiano.faoanime.utils

import android.os.Handler
import android.os.Looper
import androidx.paging.PageKeyedDataSource
import androidx.paging.PositionalDataSource
import com.fabiano.faoanime.models.Anime
import com.fabiano.faoanime.requests.SearchRequest
import java.util.concurrent.Executor

class ListDataSource<T>(private val items: ArrayList<T>) : PositionalDataSource<T>() {
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<T>) {
        callback.onResult(items, 0, items.size)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<T>) {}
}

// UiThreadExecutor implementation example
class UiThreadExecutor : Executor {
    private val handler = Handler(Looper.getMainLooper())
    override fun execute(command: Runnable) {
        handler.post(command)
    }
}


class TesteDataSource(val stringSearch: String) : PageKeyedDataSource<Int, Anime>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Anime>
    ) {
        val page = 1
        SearchRequest(stringSearch, page) { value, error ->
            if (value != null) callback.onResult(value.results ?: arrayListOf(), null, page)
            if (error != null) { }
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Anime>
    ) {
        val page = 1
        SearchRequest(stringSearch, page) { value, error ->
            if (value != null) callback.onResult(value.results ?: arrayListOf(), page)
            if (error != null) {
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Anime>
    ) {
        val page = 1
        SearchRequest(stringSearch, page) { value, error ->
            if (value != null) callback.onResult(value.results ?: arrayListOf(), page)
            if (error != null) { }
        }
    }
}
