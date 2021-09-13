package com.tochapps.ceibatestapp.data.network.use_case

import com.tochapps.ceibatestapp.base.BaseUseCase
import com.tochapps.ceibatestapp.common.DataState
import com.tochapps.ceibatestapp.common.asCommonFlow
import com.tochapps.ceibatestapp.common.error.GenericErrorMapper
import com.tochapps.ceibatestapp.data.local.model.PostItemEntity
import com.tochapps.ceibatestapp.data.network.repository.user.UserDataRepository
import javax.inject.Inject

class GetPostUserUC @Inject constructor(
    private val repository: UserDataRepository,
) : BaseUseCase() {

    fun execute(
        userId:Int
    ) = handlerErrorMapper<List<PostItemEntity>>(GenericErrorMapper) {
        emit(DataState.loading())
        val data = repository.getPostUser(userId)
        emit(DataState.data(data))
    }.asCommonFlow()
}