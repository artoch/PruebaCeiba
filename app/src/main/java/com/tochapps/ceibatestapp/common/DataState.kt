package com.tochapps.ceibatestapp.common

import com.tochapps.ceibatestapp.common.error.ErrorDomain

data class DataState<T>(
    val error: ErrorDomain? = null,
    val data: T? = null,
    val isLoading: Boolean = false,
) {

    companion object {

        fun <T> error(error: ErrorDomain): DataState<T> = DataState(error = error)

        fun <T> data(data: T? = null): DataState<T> = DataState(data = data)

        fun <T> loading() = DataState<T>(isLoading = true)
    }
}