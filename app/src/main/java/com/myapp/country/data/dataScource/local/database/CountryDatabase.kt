package com.myapp.country.data.dataScource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.myapp.country.data.dataScource.local.database.CountryDatabase.Companion.DB_VERSION
import com.myapp.country.domain.entities.Country

@Database(
    entities = [Country::class],
    version = DB_VERSION,
    exportSchema = false
)
@TypeConverters(FlagConverter::class, CountryNameConverter::class)
abstract class CountryDatabase: RoomDatabase() {

    abstract fun getCountryDAO(): CountryDAO

    companion object {
        const val COUNTRY_TABLE = "COUNTRY_TABLE"
        const val DATABASE_NAME = "COUNTRY_DB"
        const val DB_VERSION = 1
    }
}