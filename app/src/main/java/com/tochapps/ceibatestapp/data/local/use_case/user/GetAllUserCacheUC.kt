package com.tochapps.ceibatestapp.data.local.use_case.user

import com.tochapps.ceibatestapp.base.BaseUseCase
import com.tochapps.ceibatestapp.common.DataState
import com.tochapps.ceibatestapp.common.error.GenericErrorMapper
import com.tochapps.ceibatestapp.data.local.model.UserItemEntity
import com.tochapps.ceibatestapp.data.local.repository.user.UserCacheRepository
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class GetAllUserCacheUC @Inject constructor(
    private val repository: UserCacheRepository,
) : BaseUseCase() {

    fun execute(
    ) = handlerErrorMapper<List<UserItemEntity>>(GenericErrorMapper) {
        repository.getAllUser().collect {
            emit(if (it.isEmpty()) (DataState.data(null)) else (DataState.data(it)))
        }
    }
}