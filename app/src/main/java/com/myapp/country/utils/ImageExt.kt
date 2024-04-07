package com.myapp.country.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.showImage(url: String, alternativeUrl: String) {
    Glide.with(context)
        .load(url)
        .error(Glide.with(context).load(alternativeUrl))
        .into(this)
}
