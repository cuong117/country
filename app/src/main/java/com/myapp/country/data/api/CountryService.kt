package com.myapp.country.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface CountryService {
    @GET("all?fields=name,flags")
    suspend fun getCountries(@Query("fields") fields: String)
}
