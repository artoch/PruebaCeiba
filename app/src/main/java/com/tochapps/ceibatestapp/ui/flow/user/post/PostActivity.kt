package com.tochapps.ceibatestapp.ui.flow.user.post

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tochapps.ceibatestapp.R
import com.tochapps.ceibatestapp.base.BaseActivity
import com.tochapps.ceibatestapp.common.USER_ID
import com.tochapps.ceibatestapp.common.error.CommonError
import com.tochapps.ceibatestapp.common.error.ErrorDomain
import com.tochapps.ceibatestapp.data.local.model.PostItemEntity
import com.tochapps.ceibatestapp.data.local.model.UserItemEntity
import com.tochapps.ceibatestapp.data.state.PostActivityState
import com.tochapps.ceibatestapp.databinding.ActivityPostBinding
import com.tochapps.ceibatestapp.ui.flow.user.post.adapter.PostItem
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : BaseActivity() {

    private lateinit var binding: ActivityPostBinding
    private val adapter by lazy { GroupieAdapter() }
    private val vm: PostViewModel by viewModels()
    private val id:Int by lazy { intent.getIntExtra(USER_ID, 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)
        subscribeObservers()
        setupView()
        vm.init(id)
    }

    private fun setupView(){
        binding.apply {
            recyclerViewPostsResults.layoutManager = LinearLayoutManager(this@PostActivity)
            recyclerViewPostsResults.adapter = adapter
        }
    }

    private fun subscribeObservers(){
        vm.state.observe(this, ::stateHandler)
        vm.user.observe(this, ::getUser)
        vm.post.observe(this, ::setPostData)
    }

    private fun getUser(userItemEntity: UserItemEntity){
        binding.apply {
            name.text = userItemEntity.name
            phone.text = userItemEntity.phone
            email.text = userItemEntity.email
        }
    }

    private fun setPostData(post: List<PostItemEntity>){
        adapter.clear()
        post.forEach{
            adapter.add(PostItem(it))
        }
    }

    private fun stateHandler(state: PostActivityState){
        showLoading(false)
        when (state){
            is PostActivityState.LoadingState -> showLoading()
            is PostActivityState.ErrorState -> errorStateHandler(state.error)
            else -> {}
        }

    }

    private fun errorStateHandler(error: ErrorDomain) =
        when (error) {
            is CommonError.ConnectError -> { Toast.makeText(this, getString(R.string.generic_message_error), Toast.LENGTH_SHORT).show() }
            else -> {
                Toast.makeText(this, getString(R.string.generic_error), Toast.LENGTH_SHORT).show() }
        }
}