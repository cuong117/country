package com.myapp.country.data.dataScource

import com.myapp.country.domain.entities.Country

interface CountryDataSource {

    suspend fun getListCountry(fields: List<String>): List<Country>
}
