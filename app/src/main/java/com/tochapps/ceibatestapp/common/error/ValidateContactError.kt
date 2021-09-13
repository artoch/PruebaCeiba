package com.tochapps.ceibatestapp.common.error

sealed class ValidateContactError : ErrorDomain() {

    object ContactAlreadyError : ValidateContactError()
}