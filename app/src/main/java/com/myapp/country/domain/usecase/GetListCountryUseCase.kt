package com.myapp.country.domain.usecase

import com.myapp.country.domain.entities.Country
import com.myapp.country.domain.repository.CountryRepository
import com.myapp.country.utils.DataResult
import com.myapp.country.utils.FieldType

class GetListCountryUseCase(private val countryRepository: CountryRepository) :
    UseCase<DataResult<List<Country>>, List<FieldType>> {

    override suspend fun call(params: List<FieldType>): DataResult<List<Country>> {
        val fields = params.map { it.value }
        return countryRepository.getListCountry(fields)
    }
}
