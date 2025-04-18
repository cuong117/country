package com.myapp.country.di

import com.myapp.country.base.EmptyViewModel
import com.myapp.country.ui.listCountry.ListCountryViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ListCountryViewModel(get(), get(), get()) }
    viewModel { EmptyViewModel() }
}
