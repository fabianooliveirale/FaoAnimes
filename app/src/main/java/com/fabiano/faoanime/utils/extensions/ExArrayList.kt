package com.fabiano.faoanime.utils.extensions

import android.os.AsyncTask
import androidx.paging.PagedList
import com.fabiano.faoanime.utils.ListDataSource
import com.fabiano.faoanime.utils.UiThreadExecutor

fun <T> ArrayList<T>.toPagedList(): PagedList<T> {
    val config = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setPageSize(1)
        .build()

    val listDataSource = ListDataSource(this)

    return PagedList.Builder(listDataSource, config)
        .setNotifyExecutor(UiThreadExecutor())
        .setFetchExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
        .build()
}