package com.myapp.country.domain.entities

import com.google.gson.annotations.SerializedName

data class Flag(
    @SerializedName("png")
    val imagePNG: String,
    @SerializedName("SVG")
    val imageSVG: String
)
