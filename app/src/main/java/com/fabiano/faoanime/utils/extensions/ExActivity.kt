package com.fabiano.faoanime.utils.extensions

import android.app.Activity
import android.content.Intent
import android.widget.Toast

fun Activity.toast(value: String) {
    Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
}