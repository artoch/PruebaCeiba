package com.tochapps.ceibatestapp.data.local.repository.user

import com.tochapps.ceibatestapp.data.local.dao.user.UserDao
import com.tochapps.ceibatestapp.data.local.model.UserItemEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserCacheRepositoryImpl @Inject constructor(
    private val dao: UserDao
): UserCacheRepository {

    override fun getAllUser(): Flow<List<UserItemEntity>> = dao.getAllUser()

    override suspend fun addAllUser(users: List<UserItemEntity>) {
        dao.addAllUser(users)
    }

    override suspend fun getUser(id: Int): UserItemEntity = dao.getUser(id)

}