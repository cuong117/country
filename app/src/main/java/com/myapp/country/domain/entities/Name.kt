package com.myapp.country.domain.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Name(
    @SerializedName("official")
    val official: String?,
    @SerializedName("common")
    val common: String?
): Parcelable
