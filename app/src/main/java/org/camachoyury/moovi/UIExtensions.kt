package org.camachoyury.moovi

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.Target

fun ImageView.loadImage(imageUrl: String, circleCrop: Boolean = false) {
    val builder = Glide.with(context)
        .load(imageUrl)

    if (circleCrop) {
        builder.circleCrop()
    }

    builder.transition(DrawableTransitionOptions.withCrossFade())
        .override(Target.SIZE_ORIGINAL)
        .into(this)
}