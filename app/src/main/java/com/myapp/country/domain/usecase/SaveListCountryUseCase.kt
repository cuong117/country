package com.myapp.country.domain.usecase

import com.myapp.country.domain.entities.Country
import com.myapp.country.domain.repository.CountryRepository

class SaveListCountryUseCase(private val countryRepository: CountryRepository) :
    UseCase<Unit, List<Country>> {
    override suspend fun call(params: List<Country>) {
        countryRepository.saveCountry(params)
    }
}