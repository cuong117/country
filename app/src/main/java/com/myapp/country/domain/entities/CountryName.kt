package com.myapp.country.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryName(
    val official: String?,
    val common: String?,
    val  nativeName: Map<String, Name>?
): Parcelable
