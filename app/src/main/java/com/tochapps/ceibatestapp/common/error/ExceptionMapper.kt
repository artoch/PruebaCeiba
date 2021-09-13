package com.tochapps.ceibatestapp.common.error

interface ExceptionMapper {

    fun getCustomError(errorEntity: ErrorEntity): ErrorDomain

    fun getGenericError(exception: Exception): ErrorDomain
}