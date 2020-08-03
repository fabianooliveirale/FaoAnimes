package com.fabiano.faoanime.utils.extensions

import android.util.TypedValue
import com.fabiano.faoanime.MyApplication

fun Int.toDP(): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        MyApplication.context.resources.displayMetrics
    )
}