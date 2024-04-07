package com.myapp.country.domain.repository

import com.myapp.country.domain.entities.Country
import com.myapp.country.utils.DataResult

interface CountryRepository {

    suspend fun getListCountryLocal(): List<Country>

    suspend fun saveCountry(listCountry: List<Country>)

    suspend fun getListCountry(fields: List<String>): DataResult<List<Country>>
}
