package com.tochapps.ceibatestapp.common.extension

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.asLiveData() = this as LiveData<T>

fun <T> MutableLiveData<T>.postValueIfDifference(data: T) {
    if (value != data) postValue(data)
}

fun <T> MutableLiveData<T>.reduce(
    sync: Boolean = false,
    reducer: T.() -> T = { this }
) {
    value?.let {
        if (sync) {
            value = it.reducer()
        } else {
            postValue(it.reducer())
        }
    }
}

@MainThread
fun <T> MutableLiveData<T?>.setValueAndClear(data: T) {
    value = data
    value = null
}