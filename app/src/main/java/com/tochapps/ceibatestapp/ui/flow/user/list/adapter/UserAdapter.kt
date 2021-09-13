package com.tochapps.ceibatestapp.ui.flow.user.list.adapter

import com.tochapps.ceibatestapp.data.local.model.UserItemEntity
import com.xwray.groupie.GroupieAdapter

class UserAdapter (
    private val action: ((Int) -> Unit)? = null
): GroupieAdapter() {

    private val item = ArrayList<UserItemEntity>()

    fun setItems(items: List<UserItemEntity>) {
        item.clear()
        item.addAll(items)
        clear()
        addAll(getItems(items))
    }

    private fun getItems(items: List<UserItemEntity>) = items.map { UserItem(it, action) }

    fun applyFilter(search: String) {
        val items = if (search.isNotBlank()) item.filter {
            it.name.lowercase().contains(search.lowercase())
        } else item
        updateAsync(getItems(items))
    }
}