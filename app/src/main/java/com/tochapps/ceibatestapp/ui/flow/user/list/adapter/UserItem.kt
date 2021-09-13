package com.tochapps.ceibatestapp.ui.flow.user.list.adapter

import com.tochapps.ceibatestapp.R
import com.tochapps.ceibatestapp.data.local.model.UserItemEntity
import com.tochapps.ceibatestapp.databinding.UserListItemBinding
import com.xwray.groupie.databinding.BindableItem

class UserItem (
    private val data: UserItemEntity,
    private val action: ((Int) -> Unit)? = null
) : BindableItem<UserListItemBinding>() {

    override fun bind(viewBinding: UserListItemBinding, position: Int) {
        viewBinding.data = data
        viewBinding.btnViewPost.setOnClickListener {
            action?.invoke(data.id)
        }
    }

    override fun getLayout() = R.layout.user_list_item
}
