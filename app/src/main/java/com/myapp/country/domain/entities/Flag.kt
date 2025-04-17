package com.myapp.country.domain.entities

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Flag(
    @SerializedName("png")
    val imagePNG: String?,
    @SerializedName("svg")
    val imageSVG: String?
): Parcelable
