package com.sample.githubusers.data.network

import com.sample.githubusers.data.Users
import com.sample.githubusers.data.UsersItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiConfig {
    @GET("users")
    fun getUsers(@Query("per_page") perPage: Int, @Query("since") since: Int): Call<Users>

    @GET("/users/{username}")
    fun getUserInfo(@Path("username") username: String): Call<UsersItem>
}