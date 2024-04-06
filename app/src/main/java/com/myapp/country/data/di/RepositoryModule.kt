package com.myapp.country.data.di

import com.myapp.country.data.repository.CountryRepositoryImpl
import com.myapp.country.domain.repository.CountryRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CountryRepository> { CountryRepositoryImpl(get()) }
}
