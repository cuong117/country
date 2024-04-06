package com.myapp.country.data.di

import com.myapp.country.data.dataScource.CountryDataSource
import com.myapp.country.data.dataScource.remote.CountryDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<CountryDataSource> { CountryDataSourceImpl(get()) }
}
