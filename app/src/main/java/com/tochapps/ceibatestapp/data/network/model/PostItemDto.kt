package com.tochapps.ceibatestapp.data.network.model

import com.tochapps.ceibatestapp.data.local.model.PostItemEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostItemDto (
    @SerialName("id")     val id:Long,
    @SerialName("userId") val userId: Int,
    @SerialName("title")  val title: String,
    @SerialName("body")   val body: String,
)

fun PostItemDto.mapToDomain() = PostItemEntity(
    id, userId, title, body
)