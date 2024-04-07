package com.myapp.country.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.myapp.country.R

fun ImageView.showImage(url: String, alternativeUrl: String) {
    Glide.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .error(Glide.with(context).load(alternativeUrl).diskCacheStrategy(DiskCacheStrategy.ALL))
        .placeholder(R.drawable.earth)
        .into(this)
}
