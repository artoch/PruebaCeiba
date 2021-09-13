package com.tochapps.ceibatestapp.data.local.dao.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tochapps.ceibatestapp.data.local.model.UserItemEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {
    @Query("SELECT * FROM user_table")
    fun getAllUser(): Flow<List<UserItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllUser(users: List<UserItemEntity>)

    @Query("SELECT * FROM user_table WHERE id = :id")
    suspend fun getUser(id:Int): UserItemEntity
}