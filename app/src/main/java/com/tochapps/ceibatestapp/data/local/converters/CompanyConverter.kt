package com.tochapps.ceibatestapp.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.tochapps.ceibatestapp.data.local.model.CompanyEntity

class CompanyConverter {
    @TypeConverter
    fun dataToJson(companyEntity: CompanyEntity) = Gson().toJson(companyEntity)

    @TypeConverter
    fun jsonToData(data: String) = Gson().fromJson(data, CompanyEntity::class.java)
}