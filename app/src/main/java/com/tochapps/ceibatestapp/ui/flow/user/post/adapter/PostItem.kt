package com.tochapps.ceibatestapp.ui.flow.user.post.adapter

import com.tochapps.ceibatestapp.R
import com.tochapps.ceibatestapp.data.local.model.PostItemEntity
import com.tochapps.ceibatestapp.databinding.PostListItemBinding
import com.xwray.groupie.databinding.BindableItem

class PostItem (
    private val data: PostItemEntity
) : BindableItem<PostListItemBinding>() {

    override fun bind(viewBinding: PostListItemBinding, position: Int) {
        viewBinding.data = data
    }

    override fun getLayout() = R.layout.post_list_item
}
