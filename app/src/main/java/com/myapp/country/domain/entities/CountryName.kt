package com.myapp.country.domain.entities

data class CountryName(val official: String, val common: String, val nativeName: Map<String, Name>)
