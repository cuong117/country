package com.myapp.country.data.dataScource.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myapp.country.domain.entities.Country

@Dao
interface CountryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(vararg country: Country)

    @Query("select * from ${CountryDatabase.COUNTRY_TABLE}")
    suspend fun getAllCountry(): List<Country>
}
