package com.tochapps.ceibatestapp.ui.flow.user.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tochapps.ceibatestapp.common.extension.asLiveData
import com.tochapps.ceibatestapp.data.local.model.PostItemEntity
import com.tochapps.ceibatestapp.data.local.model.UserItemEntity
import com.tochapps.ceibatestapp.data.local.use_case.user.GetUserCacheUC
import com.tochapps.ceibatestapp.data.network.use_case.GetPostUserUC
import com.tochapps.ceibatestapp.data.state.PostActivityState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getUserCacheUC: GetUserCacheUC,
    private val getPostUserUC: GetPostUserUC
): ViewModel() {

    private val _state = MutableLiveData<PostActivityState>()
    val state = _state.asLiveData()

    private val _user = MutableLiveData<UserItemEntity>()
    val user = _user.asLiveData()

    private val _post = MutableLiveData<List<PostItemEntity>>()
    val post = _post.asLiveData()

    fun init(id:Int){
        getUserById(id)
    }

    private fun getUserById(id:Int){
        getUserCacheUC.execute(id).collectCommon(viewModelScope){ dataState ->
            if (dataState.data!= null) {
                _user.value = dataState.data
                getUserPost(id)
            }
            else
                println("UN ERROR HA OCURRIDO")
        }
    }

    private fun getUserPost(id:Int){
        getPostUserUC.execute(id).collectCommon(viewModelScope){ dataState ->
            _state.value = when{
                dataState.isLoading -> PostActivityState.LoadingState
                dataState.data != null -> getPostData(dataState.data)
                else -> PostActivityState.ErrorState(dataState.error!!)
            }
        }
    }

    private fun getPostData(data: List<PostItemEntity>):PostActivityState{
        _post.value = data
        return PostActivityState.SuccessPostData
    }
}