package com.tochapps.ceibatestapp.data.local.repository.user

import com.tochapps.ceibatestapp.data.local.model.UserItemEntity
import kotlinx.coroutines.flow.Flow

interface UserCacheRepository  {

    fun getAllUser(): Flow<List<UserItemEntity>>

    suspend fun addAllUser(users: List<UserItemEntity>)

    suspend fun getUser(id:Int): UserItemEntity
}