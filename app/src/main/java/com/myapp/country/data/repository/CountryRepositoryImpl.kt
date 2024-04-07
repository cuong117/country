package com.myapp.country.data.repository

import com.myapp.country.base.BaseRepository
import com.myapp.country.data.dataScource.CountryDataSource
import com.myapp.country.domain.entities.Country
import com.myapp.country.domain.repository.CountryRepository

class CountryRepositoryImpl(private val countryDataSource: CountryDataSource) : CountryRepository,
    BaseRepository() {
    override suspend fun getListCountryLocal() = countryDataSource.getListCountryLocal()

    override suspend fun saveCountry(listCountry: List<Country>) =
        countryDataSource.saveCountry(listCountry)

    override suspend fun getListCountry(fields: List<String>) = getResult {
        countryDataSource.getListCountry(fields)
    }
}
