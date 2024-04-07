package com.myapp.country.di

import android.app.Application
import com.myapp.country.data.di.dataSourceModule
import com.myapp.country.data.di.netWorkModule
import com.myapp.country.data.di.repositoryModule
import com.myapp.country.domain.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CountryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val modules = listOf(
            netWorkModule,
            dataSourceModule,
            repositoryModule,
            useCaseModule,
            viewModelModule
        )
        startKoin {
            androidContext(this@CountryApplication)
            modules(modules)
        }
    }
}
