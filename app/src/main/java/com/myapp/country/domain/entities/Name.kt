package com.myapp.country.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Name(val official: String?, val common: String?): Parcelable
