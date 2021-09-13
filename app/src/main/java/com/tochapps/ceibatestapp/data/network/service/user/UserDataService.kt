package com.tochapps.ceibatestapp.data.network.service.user

import com.tochapps.ceibatestapp.data.network.model.PostItemDto
import com.tochapps.ceibatestapp.data.network.model.UserItemDto

interface UserDataService {
    suspend fun getAllUser(): List<UserItemDto>

    suspend fun getPostUser(userId:Int): List<PostItemDto>
}