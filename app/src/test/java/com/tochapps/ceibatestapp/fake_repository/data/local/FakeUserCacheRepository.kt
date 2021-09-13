package com.tochapps.ceibatestapp.fake_repository.data.local

import com.tochapps.ceibatestapp.data.local.model.UserItemEntity

class FakeUserCacheRepository {

    private val users = ArrayList<UserItemEntity>()

    fun getAllUser(): List<UserItemEntity> = users

    fun addAllUser(users: List<UserItemEntity>){
        this.users.addAll(users)
    }

}