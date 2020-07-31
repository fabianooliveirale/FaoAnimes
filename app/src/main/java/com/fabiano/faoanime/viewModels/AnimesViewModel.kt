package com.fabiano.faoanime.viewModels

import android.util.Log.d
import com.fabiano.faoanime.utils.extensions.debounce
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class AnimesViewModel : BaseViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main
    var searchString = ""

    val textchanger: (String) -> Unit = debounce(
        500L,
        this
    ) {
        d("value", "teste $it")
    }
}