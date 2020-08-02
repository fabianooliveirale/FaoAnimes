package com.fabiano.faoanime.utils

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    Log.d("loadImage", "$imageUrl")
    Picasso.get()
        .load(imageUrl)
        .into(view)
}