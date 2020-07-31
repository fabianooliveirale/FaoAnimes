package com.fabiano.faoanime.utils

import android.content.Context
import android.os.Handler
import android.util.TypedValue
import android.view.View
import android.view.animation.PathInterpolator
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo


class ViewAnimation {
    private var baseDurationAnime: Long = 890
    private val easeOut = PathInterpolator(.33f, 1f, .7f, 1f)
    private var handler: Handler? = null
    var inAnimation = false

    init {
        handler = Handler()
    }

    fun slideInRight(view: View, delay: Long = 0, duration: Long = baseDurationAnime) {
        view.isVisible = false
        handler?.postDelayed({
            YoYo.with(Techniques.SlideInRight)
                .duration(duration)
                .interpolate(easeOut)
                .onStart {
                    view.visibility = View.VISIBLE
                }
                .playOn(view)
        }, delay)
    }

    fun slideInLeft(view: View, delay: Long = 0, duration: Long = baseDurationAnime) {
        view.isVisible = false
        handler?.postDelayed({
            YoYo.with(Techniques.SlideInLeft)
                .duration(duration)
                .interpolate(easeOut)
                .onStart {
                    view.visibility = View.VISIBLE
                }
                .playOn(view)
        }, delay)
    }

    fun splashImageFadeInUp(
        view: View,
        delay: Long = 0,
        duration: Long = baseDurationAnime,
        context: Context
    ) {
        val translationX =
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                -45F,
                context.resources.displayMetrics
            )
        view.visibility = View.INVISIBLE
        handler?.postDelayed({
            YoYo.with(Techniques.FadeInUp)
                .duration(duration)
                .interpolate(easeOut)
                .onStart {
                    view.translationX = translationX
                    view.scaleX = 1.7F
                    view.scaleY = 1.7F
                    view.visibility = View.VISIBLE
                }
                .playOn(view)
        }, delay)
    }

    fun splashImageFadeInDown(
        view: View,
        context: Context,
        delay: Long = 0,
        duration: Long = baseDurationAnime
    ) {
        val translationX =
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                45F,
                context.resources.displayMetrics
            )
        view.visibility = View.INVISIBLE
        handler?.postDelayed({
            YoYo.with(Techniques.FadeInDown)
                .duration(duration)
                .interpolate(easeOut)
                .onStart {
                    view.translationX =
                        translationX
                    view.scaleX = 1.3F
                    view.scaleY = 1.3F
                    view.visibility = View.VISIBLE
                }
                .playOn(view)
        }, delay)
    }

    fun fadeIn(
        view: View,
        delay: Long = 0,
        durationAnimation: Long = baseDurationAnime,
        ended: (() -> Unit)? = null
    ) {
        view.visibility = View.INVISIBLE
        handler?.postDelayed({
            YoYo.with(Techniques.FadeIn)
                .duration(durationAnimation)
                .interpolate(easeOut)
                .onStart {
                    view.visibility = View.VISIBLE
                }.onEnd {
                    if (ended != null) {
                        ended()
                    }
                }
                .playOn(view)
        }, delay)
    }

    fun fadeInUp(
        view: View,
        delay: Long = 0,
        durationAnimation: Long = baseDurationAnime,
        ended: (() -> Unit)? = null
    ) {
        try {
            view.visibility = View.INVISIBLE
            handler?.postDelayed({
                YoYo.with(Techniques.FadeInUp)
                    .duration(durationAnimation)
                    .interpolate(easeOut)
                    .onStart {
                        view.visibility = View.VISIBLE
                    }.onEnd {
                        if (ended != null) {
                            ended()
                        }
                    }.playOn(view)
            }, delay)
        } catch (e: Exception) {
        }
    }

    fun fadeInLeft(
        view: View,
        delay: Long = 0,
        durationAnimation: Long = baseDurationAnime
    ) {
        view.visibility = View.INVISIBLE
        handler?.postDelayed({
            YoYo.with(Techniques.FadeInLeft)
                .duration(durationAnimation)
                .interpolate(easeOut)
                .onStart {
                    view.visibility = View.VISIBLE
                }
                .playOn(view)
        }, delay)
    }

    fun fadeInRight(
        view: View,
        delay: Long = 0,
        durationAnimation: Long = baseDurationAnime
    ) {
        view.visibility = View.INVISIBLE
        handler?.postDelayed({
            YoYo.with(Techniques.FadeInRight)
                .duration(durationAnimation)
                .interpolate(easeOut)
                .onStart {
                    view.visibility = View.VISIBLE
                }
                .playOn(view)
        }, delay)
    }

    fun fadeInDown(
        view: View,
        delay: Long = 0,
        durationAnimation: Long = baseDurationAnime
    ) {

        view.visibility = View.INVISIBLE
        handler?.postDelayed({
            YoYo.with(Techniques.FadeInDown)
                .duration(durationAnimation)
                .interpolate(PathInterpolator(.22f, 1f, .36f, 1f))
                .onStart {
                    view.visibility = View.VISIBLE
                }
                .playOn(view)
        }, delay)

    }

    fun fadeInDownLogo(
        view: View,
        delay: Long = 0,
        durationAnimation: Long = baseDurationAnime
    ) {

        view.visibility = View.INVISIBLE
        handler?.postDelayed({
            YoYo.with(Techniques.FadeInDown)
                .duration(durationAnimation)
                .interpolate(easeOut)
                .onStart {
                    view.scaleX = 1.3F
                    view.scaleY = 1.3F
                    view.visibility = View.VISIBLE
                }
                .playOn(view)
        }, delay)

    }

    fun slideInUp(
        view: View,
        delay: Long = 0,
        durationAnimation: Long = baseDurationAnime
    ) {
        view.visibility = View.INVISIBLE
        handler?.postDelayed({
            YoYo.with(Techniques.SlideInUp)
                .duration(durationAnimation)
                .onStart { view.visibility = View.VISIBLE }
                .interpolate(easeOut)
                .playOn(view)
        }, delay)
    }

    fun slideInDown(
        view: View,
        delay: Long = 0,
        durationAnimation: Long = baseDurationAnime
    ) {
        view.visibility = View.INVISIBLE
        handler?.postDelayed({
            YoYo.with(Techniques.SlideInDown)
                .duration(durationAnimation)
                .onStart { view.visibility = View.VISIBLE }
                .interpolate(easeOut)
                .playOn(view)
        }, delay)
    }

    fun slideInUpImage(
        view: View,
        delay: Long = 0,
        durationAnimation: Long = baseDurationAnime,
        context: Context
    ) {
        val translationX =
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                -45F,
                context.resources.displayMetrics
            )
        view.visibility = View.INVISIBLE
        handler?.postDelayed({
            YoYo.with(Techniques.SlideInUp)
                .duration(durationAnimation)
                .interpolate(easeOut)
                .onStart {
                    view.translationX = translationX
                    view.scaleX = 1.7F
                    view.scaleY = 1.7F
                    view.visibility = View.VISIBLE
                }
                .playOn(view)
        }, delay)
    }

    fun fadeIn(
        view: View,
        delay: Long = 0,
        duration: Long = baseDurationAnime
    ) {
        if (inAnimation) return
        handler?.postDelayed({
            YoYo.with(Techniques.FadeIn)
                .duration(duration)
                .interpolate(easeOut)
                .onStart {
                    inAnimation = true
                    view.isGone = false
                }.onEnd {
                    inAnimation = false
                }.playOn(view)
        }, delay)
    }

    fun fadeOut(
        view: View,
        delay: Long = 0,
        duration: Long = baseDurationAnime
    ) {
        if (inAnimation) return
        handler?.postDelayed({
            YoYo.with(Techniques.FadeOut)
                .duration(duration)
                .interpolate(easeOut)
                .onStart {
                    inAnimation = true
                }
                .onEnd {
                    inAnimation = false
                    view.isGone = true
                }.playOn(view)
        }, delay)
    }
}