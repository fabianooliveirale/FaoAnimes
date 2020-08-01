package com.fabiano.faoanime.screens.animes

import android.graphics.drawable.Drawable
import androidx.lifecycle.MutableLiveData
import com.fabiano.faoanime.MyApplication
import com.fabiano.faoanime.R
import com.fabiano.faoanime.utils.extensions.debounce
import com.fabiano.faoanime.bases.BaseViewModel
import com.fabiano.faoanime.models.Anime
import com.fabiano.faoanime.models.SearchItem
import com.fabiano.faoanime.requests.SearchRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class AnimesViewModel : BaseViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO

    var animesLiveData: MutableLiveData<ArrayList<Anime>> = MutableLiveData()
    var searchLiveData: MutableLiveData<SearchItem> = MutableLiveData()

    val textchanger: (String) -> Unit = debounce(
        500L,
        this
    ) { searchString ->
        requestSearch(searchString)
    }


    fun getSearchIcon(isGone: Boolean): Drawable? =
        if (isGone) MyApplication.context.getDrawable(R.drawable.ic_close)
        else MyApplication.context.getDrawable(R.drawable.ic_search)


    private fun requestSearch(searchString: String) {
        SearchRequest(searchString) { value, error ->
            if (value != null) responseInterface?.success(value)
            if (error != null) responseInterface?.error(error)
        }
    }
}