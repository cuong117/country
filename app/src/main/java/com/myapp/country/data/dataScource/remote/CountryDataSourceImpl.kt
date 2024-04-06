package com.myapp.country.data.dataScource.remote

import com.myapp.country.data.dataScource.CountryDataSource
import com.myapp.country.data.dataScource.remote.api.CountryService

class CountryDataSourceImpl(private val countryService: CountryService) : CountryDataSource {
    override suspend fun getListCountry(fields: List<String>) = countryService.getListCountry(fields)
}
