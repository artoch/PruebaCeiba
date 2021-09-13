package com.tochapps.ceibatestapp.data.network.use_case

import com.tochapps.ceibatestapp.base.BaseUseCase
import com.tochapps.ceibatestapp.common.DataState
import com.tochapps.ceibatestapp.common.asCommonFlow
import com.tochapps.ceibatestapp.common.error.GenericErrorMapper
import com.tochapps.ceibatestapp.data.local.model.UserItemEntity
import com.tochapps.ceibatestapp.data.network.repository.user.UserDataRepository
import javax.inject.Inject

class GetAllUserUC @Inject constructor(
    private val repository: UserDataRepository,
) : BaseUseCase() {

    fun execute() = handlerErrorMapper<List<UserItemEntity>>(GenericErrorMapper) {
        emit(DataState.loading())
        val data = repository.getAllUser()
        emit(DataState.data(data))
    }.asCommonFlow()
}