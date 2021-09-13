package com.tochapps.ceibatestapp.data.state

import com.tochapps.ceibatestapp.common.error.ErrorDomain

sealed class PostActivityState {


    object LoadingState : PostActivityState()

    object SuccessPostData  : PostActivityState()

    data class ErrorState(val error: ErrorDomain) : PostActivityState()
}