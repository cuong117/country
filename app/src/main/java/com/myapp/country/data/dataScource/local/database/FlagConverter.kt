package com.myapp.country.data.dataScource.local.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.myapp.country.domain.entities.Flag

@ProvidedTypeConverter
class FlagConverter {

    @TypeConverter
    fun fromJson(value: String): Flag {
        return Gson().fromJson(value, Flag::class.java)
    }

    @TypeConverter
    fun fromFlag(flag: Flag): String {
        return Gson().toJson(flag)
    }
}
