package com.example.harajtask.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.harajtask.pojo.Post
import com.example.harajtask.util.MyJsonParser
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PostListViewModel(application: Application) : AndroidViewModel(application){

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>>
        get() = _posts

    fun getPosts() {
        val jsonFileString = MyJsonParser.getJsonDataFromAsset(getApplication(), "data.json")

        val gson = Gson()
        val listPersonType = object : TypeToken<List<Post>>() {}.type

        val result: List<Post> = gson.fromJson(jsonFileString, listPersonType)
        _posts.value = result;
        result.forEachIndexed { idx, post -> Log.i("data", "> Item $idx:\n$post") }
    }
}