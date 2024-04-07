package com.myapp.country.data.dataScource

import com.myapp.country.data.dataScource.local.database.CountryDAO
import com.myapp.country.data.dataScource.remote.api.CountryService
import com.myapp.country.domain.entities.Country

class CountryDataSourceImpl(
    private val countryService: CountryService,
    private val countryDAO: CountryDAO
) : CountryDataSource {
    override suspend fun getListCountryLocal() = countryDAO.getAllCountry()
    override suspend fun saveCountry(listCountry: List<Country>) =
        countryDAO.insertCountry(*listCountry.toTypedArray())

    override suspend fun getListCountry(fields: List<String>) =
        countryService.getListCountry(fields)


}
