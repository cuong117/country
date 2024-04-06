package com.myapp.country.di

import com.myapp.country.ui.listCountry.ListCountryViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { ListCountryViewModel(get()) }
}
