package com.myapp.country.data.dataScource.local.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.myapp.country.domain.entities.CountryName

@ProvidedTypeConverter
class CountryNameConverter(private val gson: Gson) {
    @TypeConverter
    fun fromNameJson(value: String): CountryName {
        return gson.fromJson(value, CountryName::class.java)
    }

    @TypeConverter
    fun toName(countryName: CountryName): String {
        return gson.toJson(countryName)
    }
}