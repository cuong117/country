package com.myapp.country.data.dataScource

import com.myapp.country.domain.entities.Country

interface CountryDataSource {

    suspend fun getListCountryLocal(): List<Country>

    suspend fun saveCountry(listCountry: List<Country>)

    suspend fun getListCountry(fields: List<String>): List<Country>
}
