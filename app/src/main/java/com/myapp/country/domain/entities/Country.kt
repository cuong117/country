package com.myapp.country.domain.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.myapp.country.data.dataScource.local.database.CountryDatabase
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = CountryDatabase.COUNTRY_TABLE)
data class Country(
    @SerializedName("flags")
    val flags: Flag?,
    @SerializedName("name")
    val name: CountryName?
): Parcelable {
    @Expose(serialize = false, deserialize = false)
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
