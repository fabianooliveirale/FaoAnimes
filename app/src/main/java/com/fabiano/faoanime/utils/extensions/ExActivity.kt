package com.fabiano.faoanime.utils.extensions

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.fabiano.faoanime.utils.KeyboardUtils

fun Activity.toast(value: String) {
    Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
}