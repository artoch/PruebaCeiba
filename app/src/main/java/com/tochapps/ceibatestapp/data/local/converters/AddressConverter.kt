package com.tochapps.ceibatestapp.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.tochapps.ceibatestapp.data.local.model.AddressEntity

class AddressConverter {
    @TypeConverter
    fun dataToJson(addressEntity: AddressEntity) = Gson().toJson(addressEntity)

    @TypeConverter
    fun jsonToData(data: String) = Gson().fromJson(data, AddressEntity::class.java)
}