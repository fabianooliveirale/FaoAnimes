package com.fabiano.faoanime.utils.extensions

import android.app.Activity
import android.content.Intent

fun Activity.initActivity(activity: Activity) {
    startActivity(Intent(this, activity::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
}

fun Activity.initActivityFinish(activity: Activity) {
    finish()
    startActivity(Intent(this, activity::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
}

fun Activity.initActivityFinishAffinity(activity: Activity) {
    finishAffinity()
    startActivity(Intent(this, activity::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
}