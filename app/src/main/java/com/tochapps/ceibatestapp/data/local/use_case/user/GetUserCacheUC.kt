package com.tochapps.ceibatestapp.data.local.use_case.user

import com.tochapps.ceibatestapp.base.BaseUseCase
import com.tochapps.ceibatestapp.common.DataState
import com.tochapps.ceibatestapp.common.asCommonFlow
import com.tochapps.ceibatestapp.common.error.GenericErrorMapper
import com.tochapps.ceibatestapp.data.local.model.UserItemEntity
import com.tochapps.ceibatestapp.data.local.repository.user.UserCacheRepository
import javax.inject.Inject

class GetUserCacheUC @Inject constructor(
    private val repository: UserCacheRepository,
) : BaseUseCase() {

    fun execute(
        id: Int
    ) = handlerErrorMapper<UserItemEntity>(GenericErrorMapper) {
        val data = repository.getUser(id)
        emit(DataState.data(data))
    }.asCommonFlow()
}