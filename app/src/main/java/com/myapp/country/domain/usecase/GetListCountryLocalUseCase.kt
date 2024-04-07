package com.myapp.country.domain.usecase

import com.myapp.country.domain.entities.Country
import com.myapp.country.domain.repository.CountryRepository

class GetListCountryLocalUseCase(private val countryRepository: CountryRepository) :
    UseCase<List<Country>, Unit> {

    override suspend fun call(params: Unit): List<Country> {
        return countryRepository.getListCountryLocal()
    }
}
