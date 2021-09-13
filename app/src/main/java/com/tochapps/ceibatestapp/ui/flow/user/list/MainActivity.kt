package com.tochapps.ceibatestapp.ui.flow.user.list

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.tochapps.ceibatestapp.R
import com.tochapps.ceibatestapp.base.BaseActivity
import com.tochapps.ceibatestapp.common.USER_ID
import com.tochapps.ceibatestapp.common.error.CommonError
import com.tochapps.ceibatestapp.common.error.ErrorDomain
import com.tochapps.ceibatestapp.common.extension.goToActivity
import com.tochapps.ceibatestapp.data.local.model.UserItemEntity
import com.tochapps.ceibatestapp.data.state.MainActivityState
import com.tochapps.ceibatestapp.databinding.ActivityMainBinding
import com.tochapps.ceibatestapp.ui.flow.user.list.adapter.UserAdapter
import com.tochapps.ceibatestapp.ui.flow.user.post.PostActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { UserAdapter(::selectItem) }
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)
        subscribeObservers()
        setupView()
        vm.init()
    }

    private fun setupView(){
        binding.apply {
            recyclerViewSearchResults.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerViewSearchResults.adapter = adapter
            editTextSearch.doAfterTextChanged{
                adapter.applyFilter(it.toString())
            }
        }
    }

    private fun subscribeObservers(){
        vm.state.observe(this, ::stateHandler)
        vm.users.observe(this, ::setUserData)
    }

    private fun setUserData(users: List<UserItemEntity>){
        adapter.setItems(users)
    }

    private fun selectItem(id:Int){
        goToActivity<PostActivity>{
            putExtra(USER_ID, id)
        }
    }

    private fun stateHandler(state: MainActivityState){
        showLoading(false)
        when (state){
            is MainActivityState.LoadingState -> showLoading()
            is MainActivityState.ErrorState -> errorStateHandler(state.error)
            else -> {}
        }

    }

    private fun errorStateHandler(error: ErrorDomain) =
        when (error) {
            is CommonError.ConnectError -> { Toast.makeText(this, getString(R.string.generic_message_error), Toast.LENGTH_SHORT).show() }
            else -> {Toast.makeText(this, getString(R.string.generic_error), Toast.LENGTH_SHORT).show() }
        }
}