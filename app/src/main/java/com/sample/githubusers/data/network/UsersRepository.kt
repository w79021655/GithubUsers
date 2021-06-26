package com.sample.githubusers.data.network

import com.sample.githubusers.data.Users
import com.sample.githubusers.ui.users.IUsersContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersRepository: IUsersContract.IUsersRepository {
    private val apiService: IApiConfig = RetrofitClient.instance.api

    override fun getUsers(perPage: Int, since: Int, onFinishedListener: IUsersContract.IUsersRepository.OnFinishedListener) {
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