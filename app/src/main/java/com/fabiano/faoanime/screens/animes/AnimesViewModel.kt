package com.fabiano.faoanime.screens.animes

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.fabiano.faoanime.MyApplication
import com.fabiano.faoanime.R
import com.fabiano.faoanime.bases.BaseViewModel
import com.fabiano.faoanime.models.Anime
import com.fabiano.faoanime.screens.animes.adapter.AnimeDataSource
import com.fabiano.faoanime.utils.extensions.debounce
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class AnimesViewModel : BaseViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main + Job()

    var animesLiveData: LiveData<PagedList<Anime>> = MutableLiveData()
    var searchLiveData: MutableLiveData<MenuItem> = MutableLiveData()

    private val pagedListConfig = PagedList.Config.Builder()
        .setPageSize(20)
        .setInitialLoadSizeHint(30)
        .setPrefetchDistance(10)
        .setEnablePlaceholders(false)
        .build()

    var animeDataSource: AnimeDataSource.Companion.DataSourceFactory? = null
    var liveData: LiveData<PagedList<Anime>>? = null

    val textchanger: (String) -> Unit = debounce(
        800L,
        this
    ) { searchString ->
        AnimeDataSource.stringSearch = searchString
        invalidate()
    }

    fun invalidate(){
        liveData?.value?.dataSource?.invalidate()
    }

    fun initDataSource() {
        animeDataSource = responseInterface?.let { AnimeDataSource.Companion.DataSourceFactory(it, this) }
        liveData = animeDataSource?.let { LivePagedListBuilder(it, pagedListConfig).build() }
        liveData?.let {
            animesLiveData = it
        }
    }

    fun getSearchIcon(isCollapse: Boolean): Drawable? =
        if (isCollapse) MyApplication.context.getDrawable(R.drawable.ic_search)
        else MyApplication.context.getDrawable(R.drawable.ic_close)
}