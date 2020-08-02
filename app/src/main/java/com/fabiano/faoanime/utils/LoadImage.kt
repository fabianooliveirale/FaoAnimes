package com.fabiano.faoanime.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    Picasso.get()
        .load(imageUrl)
        .into(view)
}

@BindingAdapter("recyclerGridAnimation")
fun recyclerGridAnimation(view: View, position: Int) {
    val animation = ViewAnimation()
    if (position % 2 == 0)
        animation.fadeInLeft(view, durationAnimation = 960)
    else
        animation.fadeInRight(view, durationAnimation = 960)
}