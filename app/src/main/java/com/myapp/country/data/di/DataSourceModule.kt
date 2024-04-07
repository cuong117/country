package com.myapp.country.data.di

import android.content.Context
import androidx.room.Room
import com.myapp.country.data.dataScource.CountryDataSource
import com.myapp.country.data.dataScource.local.database.CountryDatabase
import com.myapp.country.data.dataScource.CountryDataSourceImpl
import com.myapp.country.data.dataScource.local.database.CountryNameConverter
import com.myapp.country.data.dataScource.local.database.FlagConverter
import org.koin.dsl.module

val dataSourceModule = module {
    single<CountryDataSource> { CountryDataSourceImpl(get(), get()) }
    single { provideCountryDatabase(get()) }
    single { provideCountryDAO(get()) }
}

private fun provideCountryDatabase(context: Context): CountryDatabase {
    return Room.databaseBuilder(
        context.applicationContext, CountryDatabase::class.java,
        CountryDatabase.DATABASE_NAME
    )
        .addTypeConverter(FlagConverter())
        .addTypeConverter(CountryNameConverter())
        .build()
}

private fun provideCountryDAO(countryDatabase: CountryDatabase) = countryDatabase.getCountryDAO()
