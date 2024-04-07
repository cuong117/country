package com.myapp.country.domain.di

import com.myapp.country.domain.usecase.GetListCountryLocalUseCase
import com.myapp.country.domain.usecase.GetListCountryUseCase
import com.myapp.country.domain.usecase.SaveListCountryUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetListCountryUseCase(get()) }
    single { SaveListCountryUseCase(get()) }
    single { GetListCountryLocalUseCase(get()) }
}
