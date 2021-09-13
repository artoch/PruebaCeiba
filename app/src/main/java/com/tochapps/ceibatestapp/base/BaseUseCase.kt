package com.tochapps.ceibatestapp.base

import com.tochapps.ceibatestapp.common.CommonFlow
import com.tochapps.ceibatestapp.common.DataState
import com.tochapps.ceibatestapp.common.DataState.Companion.error
import com.tochapps.ceibatestapp.common.asCommonFlow
import com.tochapps.ceibatestapp.common.error.ExceptionMapper
import com.tochapps.ceibatestapp.common.extension.handleExceptionMapper
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow


abstract class BaseUseCase {

    protected fun <T> handlerErrorMapper(
        exceptionMapper: ExceptionMapper,
        action: suspend FlowCollector<DataState<T>>.() -> Unit
    ): CommonFlow<DataState<T>> = flow {
        try {
            this.action()
        } catch (e: Exception) {
            val error = e.handleExceptionMapper(exceptionMapper)
            emit(error<T>(error))
        }
    }.asCommonFlow()
}