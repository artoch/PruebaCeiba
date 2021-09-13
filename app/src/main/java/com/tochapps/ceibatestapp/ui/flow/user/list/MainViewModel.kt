package com.tochapps.ceibatestapp.ui.flow.user.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tochapps.ceibatestapp.common.extension.asLiveData
import com.tochapps.ceibatestapp.data.local.model.UserItemEntity
import com.tochapps.ceibatestapp.data.local.use_case.user.AddAllUserCacheUC
import com.tochapps.ceibatestapp.data.local.use_case.user.GetAllUserCacheUC
import com.tochapps.ceibatestapp.data.network.use_case.GetAllUserUC
import com.tochapps.ceibatestapp.data.state.MainActivityState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllUserUC: GetAllUserUC,
    private val addAllUserCacheUC: AddAllUserCacheUC,
    private val getAllUserCacheUC: GetAllUserCacheUC
): ViewModel() {

    private val _state = MutableLiveData<MainActivityState>()
    val state = _state.asLiveData()

    private val _users = MutableLiveData<List<UserItemEntity>>()
    val users = _users.asLiveData()

    fun init(){
        getLocalData()
    }

    private fun getLocalData(){
        getAllUserCacheUC.execute().collectCommon(viewModelScope){ dataState ->
            if (dataState.data != null){
                _users.value = dataState.data.orEmpty()
            }else{
                getRemoteData()
            }
        }
    }

    private fun getRemoteData(){
        getAllUserUC.execute().collectCommon(viewModelScope){ dataState ->
            _state.value = when{
                dataState.isLoading -> MainActivityState.LoadingState
                dataState.data != null -> saveDataToLocalStorage(dataState.data)
                else -> MainActivityState.ErrorState(dataState.error!!)
            }
        }
    }

    private fun saveDataToLocalStorage(data: List<UserItemEntity>): MainActivityState {
        addAllUserCacheUC.execute(data).collectCommon(viewModelScope){ dataState ->
            _state.value = when{
                dataState.data != null -> MainActivityState.SuccessLocalUser
                else -> MainActivityState.ErrorState(dataState.error!!)
            }
        }
        return MainActivityState.SuccessDataUser
    }

}