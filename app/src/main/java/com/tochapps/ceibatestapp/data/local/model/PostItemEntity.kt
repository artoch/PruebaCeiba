package com.tochapps.ceibatestapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "post_table")
data class PostItemEntity (
    @PrimaryKey(autoGenerate = false)
    val id:Long,
    val userId: Int,
    val title: String,
    val body: String,
)