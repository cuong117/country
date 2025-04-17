package com.myapp.country.data.dataScource.local.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.myapp.country.domain.entities.CountryName
import com.myapp.country.domain.entities.Flag

@ProvidedTypeConverter
class FlagConverter(private val gson: Gson) {

    @TypeConverter
    fun fromFlagJson(value: String): Flag {
        return gson.fromJson(value, Flag::class.java)
    }

    @TypeConverter
    fun toFlagJson(flag: Flag): String {
        return gson.toJson(flag)
    }

    @TypeConverter
    fun fromNameJson(value: String): CountryName {
        return gson.fromJson(value, CountryName::class.java)
    }

    @TypeConverter
    fun toName(countryName: CountryName): String {
        return gson.toJson(countryName)
    }
}
