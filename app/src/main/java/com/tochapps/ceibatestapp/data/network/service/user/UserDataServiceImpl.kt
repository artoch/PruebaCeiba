package com.tochapps.ceibatestapp.data.network.service.user

import com.tochapps.ceibatestapp.data.network.model.PostItemDto
import com.tochapps.ceibatestapp.data.network.model.UserItemDto
import io.ktor.client.*
import io.ktor.client.request.*

class UserDataServiceImpl constructor(
    private val httpClient: HttpClient,
    private val baseUrl: String)
    : UserDataService {

    val GET_USERS = "users"
    val GET_POST_USER = "posts"
    val USER_ID_KEY = "userId"

    override suspend fun getAllUser(): List<UserItemDto> = httpClient.get{
        url("$baseUrl$GET_USERS")
    }

    override suspend fun getPostUser(userId: Int): List<PostItemDto> = httpClient.get{
        url("$baseUrl$GET_POST_USER")
        parameter(USER_ID_KEY, userId)
    }


}