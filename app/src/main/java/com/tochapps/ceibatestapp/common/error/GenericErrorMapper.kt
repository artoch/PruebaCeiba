package com.tochapps.ceibatestapp.common.error

object GenericErrorMapper : ExceptionMapper {

    override fun getCustomError(errorEntity: ErrorEntity) = CommonError.GenericServiceError

    override fun getGenericError(exception: Exception) = CommonError.GenericServiceError
}