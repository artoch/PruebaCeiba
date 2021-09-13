package com.tochapps.ceibatestapp.data.state

import com.tochapps.ceibatestapp.common.error.ErrorDomain

sealed class MainActivityState {


    object LoadingState : MainActivityState()

    object EmptyLocalUser : MainActivityState()

    object SuccessLocalUser : MainActivityState()

    object SuccessDataUser   : MainActivityState()

    data class ErrorState(val error: ErrorDomain) : MainActivityState()
}