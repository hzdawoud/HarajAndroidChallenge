package com.example.harajtask.pojo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post (
    val title: String,
    val username: String,
    val thumbURL: String,
    val commentCount: Int,
    val city: String,
    val date: Long,
    val body: String
    ) : Parcelable
