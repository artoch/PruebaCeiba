package com.tochapps.ceibatestapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tochapps.ceibatestapp.data.local.converters.AddressConverter
import com.tochapps.ceibatestapp.data.local.converters.CompanyConverter
import com.tochapps.ceibatestapp.data.local.converters.GeoConverter
import com.tochapps.ceibatestapp.data.local.dao.user.UserDao
import com.tochapps.ceibatestapp.data.local.model.PostItemEntity
import com.tochapps.ceibatestapp.data.local.model.UserItemEntity

@Database(entities = [PostItemEntity::class, UserItemEntity::class], version = 1, exportSchema = false)
@TypeConverters(AddressConverter::class, CompanyConverter::class, GeoConverter::class)
abstract class AppDataBase: RoomDatabase() {
    abstract fun  getUserDao(): UserDao
}