package com.tochapps.ceibatestapp.data.network.model

import com.tochapps.ceibatestapp.data.local.model.AddressEntity
import com.tochapps.ceibatestapp.data.local.model.CompanyEntity
import com.tochapps.ceibatestapp.data.local.model.GeoEntity
import com.tochapps.ceibatestapp.data.local.model.UserItemEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserItemDto(
    @SerialName("address") val address: AddressDto,
    @SerialName("company") val company: CompanyDto,
    @SerialName("email")   val email: String,
    @SerialName("id")      val id: Int,
    @SerialName("name")    val name: String,
    @SerialName("phone")   val phone: String,
    @SerialName("username")val username: String,
    @SerialName("website") val website: String
)

fun UserItemDto.mapToRoom() = UserItemEntity(
    address.mapToRoom(), company.mapToRoom(), email, id, name, phone, username, website
)

@Serializable
data class AddressDto(
    @SerialName("city") val city: String,
    @SerialName("geo") val geo: GeoDto,
    @SerialName("street") val street: String,
    @SerialName("suite") val suite: String,
    @SerialName("zipcode") val zipcode: String
)

fun AddressDto.mapToRoom() = AddressEntity(
    city, geo.mapToRoom(), street, suite, zipcode
)

@Serializable
data class CompanyDto(
    @SerialName("bs") val bs: String,
    @SerialName("catchPhrase") val catchPhrase: String,
    @SerialName("name") val name: String
)

fun CompanyDto.mapToRoom() = CompanyEntity(
    bs, catchPhrase, name
)

@Serializable
data class GeoDto(
    @SerialName("lat") val lat: String,
    @SerialName("lng") val lng: String
)

fun GeoDto.mapToRoom() = GeoEntity(
    lat, lng
)