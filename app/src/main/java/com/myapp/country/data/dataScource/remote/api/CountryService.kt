package com.myapp.country.data.dataScource.remote.api

import com.myapp.country.domain.entities.Country
import retrofit2.http.GET
import retrofit2.http.Query

interface CountryService {
    @GET("all")
    suspend fun getListCountry(@Query("fields") fields: List<String>): List<Country>
}
