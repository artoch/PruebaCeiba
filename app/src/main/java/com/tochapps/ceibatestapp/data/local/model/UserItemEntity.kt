package com.tochapps.ceibatestapp.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.tochapps.ceibatestapp.data.local.converters.AddressConverter
import com.tochapps.ceibatestapp.data.local.converters.CompanyConverter
import com.tochapps.ceibatestapp.data.local.converters.GeoConverter

@Entity(tableName = "user_table")
data class UserItemEntity(
    @TypeConverters(AddressConverter::class)
    @Embedded(prefix = "address_")
    val address: AddressEntity,
    @TypeConverters(CompanyConverter::class)
    @Embedded(prefix = "company_")
    val company: CompanyEntity,
    val email: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)

@Entity(tableName = "address_table")
data class AddressEntity(
    val city: String,
    @TypeConverters(GeoConverter::class)
    @Embedded(prefix = "geo_")
    val geo: GeoEntity,
    val street: String,
    val suite: String,
    val zipcode: String,
)

@Entity(tableName = "company_table")
data class CompanyEntity(
    val bs: String,
    val catchPhrase: String,
    val name: String,
)

@Entity(tableName = "geo_table")
data class GeoEntity(
    val lat: String,
    val lng: String
)