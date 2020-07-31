package com.fabiano.faoanime.screens.animes

import com.fabiano.faoanime.utils.extensions.debounce
import com.fabiano.faoanime.bases.BaseViewModel
import com.fabiano.faoanime.requests.SearchRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class AnimesViewModel : BaseViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main

    val textchanger: (String) -> Unit = debounce(
        500L,
        this
    ) { searchString ->
        requestSearch(searchString)
    }

    private fun requestSearch(searchString: String) {
        SearchRequest(searchString) { value, error ->
            if (value != null) responseInterface?.success(value)
            if (error != null) responseInterface?.error(error)
        }
    }
}