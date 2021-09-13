package com.tochapps.ceibatestapp.data.network.repository.user

import com.tochapps.ceibatestapp.data.local.model.PostItemEntity
import com.tochapps.ceibatestapp.data.local.model.UserItemEntity
import com.tochapps.ceibatestapp.data.network.model.mapToDomain
import com.tochapps.ceibatestapp.data.network.model.mapToRoom
import com.tochapps.ceibatestapp.data.network.service.user.UserDataService
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val service: UserDataService
): UserDataRepository {
    override suspend fun getAllUser(): List<UserItemEntity> = service.getAllUser().map { it.mapToRoom() }

    override suspend fun getPostUser(userId: Int): List<PostItemEntity> = service.getPostUser(userId).map {it.mapToDomain()}
}