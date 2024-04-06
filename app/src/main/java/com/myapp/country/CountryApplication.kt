package com.myapp.country

import android.app.Application
import com.myapp.country.data.di.netWorkModule
import org.koin.core.context.startKoin

class CountryApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        val modules = listOf(netWorkModule)
        startKoin { modules(modules) }
    }
}
