package com.tochapps.ceibatestapp.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.tochapps.ceibatestapp.data.local.model.GeoEntity

class GeoConverter {
    @TypeConverter
    fun dataToJson(geoEntity: GeoEntity) = Gson().toJson(geoEntity)

    @TypeConverter
    fun jsonToData(data: String) = Gson().fromJson(data, GeoEntity::class.java)
}