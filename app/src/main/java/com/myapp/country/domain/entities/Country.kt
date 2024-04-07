package com.myapp.country.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(val flags: Flag, val name: CountryName): Parcelable
