package com.myapp.country.domain.di

import com.myapp.country.domain.usecase.GetListCountryUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetListCountryUseCase(get()) }
}
