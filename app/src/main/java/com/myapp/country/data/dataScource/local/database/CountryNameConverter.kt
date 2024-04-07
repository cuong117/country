package com.myapp.country.data.dataScource.local.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.myapp.country.domain.entities.CountryName
import com.myapp.country.domain.entities.Flag

@ProvidedTypeConverter
class CountryNameConverter {
    @TypeConverter
    fun fromJson(value: String): CountryName {
        return Gson().fromJson(value, CountryName::class.java)
    }

    @TypeConverter
    fun fromFlag(countryName: CountryName): String {
        return Gson().toJson(countryName)
    }
}