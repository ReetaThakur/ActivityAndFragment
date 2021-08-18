package com.example.activityandfragment

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET(" /api/users/{userId}")
    fun getUser(@Path("userId") userId:Int):Call<ResponceModel>
}