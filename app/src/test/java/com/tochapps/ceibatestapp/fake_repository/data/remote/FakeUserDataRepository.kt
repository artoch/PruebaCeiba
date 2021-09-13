package com.tochapps.ceibatestapp.fake_repository.data.remote

import com.tochapps.ceibatestapp.data.local.model.*

class FakeUserDataRepository {

    private val remoteUser = arrayListOf(
        UserItemEntity(
            address = AddressEntity(
                city = "POZ",
                geo = GeoEntity(
                    "1",
                    "2"
                ),
                "Blv",
                "IDK",
                "1111",
            ),
            CompanyEntity(
                "2222",
                "aaaaa",
                "aAAAAA"
            ),
            "test@gmail.com",
            1,
            "A",
            "1",
            "AAAA",
            ".com"
        ),
        UserItemEntity(
            address = AddressEntity(
                city = "POZ",
                geo = GeoEntity(
                    "1",
                    "2"
                ),
                "Blv",
                "IDK",
                "1111",
            ),
            CompanyEntity(
                "2222",
                "aaaaa",
                "aAAAAA"
            ),
            "test@gmail.com",
            2,
            "AV",
            "1V",
            "AACCAA",
            ".com"
        ),
    )

    fun getAllUser(): List<UserItemEntity> = remoteUser

    private val getPostUser = listOf(
        PostItemEntity(
            1,
            1,
            "AAAA",
            "aaaaa"
        ),
        PostItemEntity(
            2,
            1,
            "AAAA",
            "aaaaa"
        ),
        PostItemEntity(
            3,
            2,
            "VVVVV",
            "aaaaa"
        )
    )

    fun getPostUser(userId: Int): List<PostItemEntity> = getPostUser.filter { it.userId == userId }
}