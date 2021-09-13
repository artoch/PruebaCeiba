package com.tochapps.ceibatestapp.data.network.repository.user

import com.tochapps.ceibatestapp.data.local.model.PostItemEntity
import com.tochapps.ceibatestapp.data.local.model.UserItemEntity

interface UserDataRepository {
    suspend fun getAllUser(): List<UserItemEntity>

    suspend fun getPostUser(userId:Int): List<PostItemEntity>
}