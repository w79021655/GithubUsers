package com.sample.githubusers.data.network

import com.sample.githubusers.data.Users
import com.sample.githubusers.ui.users.IUsersPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query

class UsersRepository {
    private val apiService: IApiConfig = RetrofitClient.instance.api

    fun getUsers(perPage: Int, since: Int, onFinishedListener: IUsersPresenter.OnFinishedListener) {
        val task = apiService.getUsers(perPage, since)

        task.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                onFinishedListener.onFinished(response.body())
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                onFinishedListener.onFailure(t)
            }
        })
    }
}