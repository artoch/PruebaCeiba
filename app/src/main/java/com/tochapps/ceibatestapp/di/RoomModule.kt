package com.tochapps.ceibatestapp.di

import android.content.Context
import androidx.room.Room
import com.tochapps.ceibatestapp.common.DATABASE_NAME
import com.tochapps.ceibatestapp.data.local.AppDataBase
import com.tochapps.ceibatestapp.data.local.dao.user.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object RoomModule {
    @Singleton
    @Provides
    fun appDatabase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun userDao(appDatabase: AppDataBase): UserDao {
        return appDatabase.getUserDao()
    }
}