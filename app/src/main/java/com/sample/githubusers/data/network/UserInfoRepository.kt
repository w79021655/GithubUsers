package com.sample.githubusers.data.network

import com.sample.githubusers.data.UsersItem
import com.sample.githubusers.ui.userinfo.IUserInfoContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserInfoRepository: IUserInfoContract.IUserInfoRepository {
    private val apiService: IApiConfig = RetrofitClient.instance.api

    override fun getUserInfo(unerName: String, onFinishedListener: IUserInfoContract.IUserInfoRepository.OnFinishedListener) {
        val task = apiService.getUserInfo(unerName)

        task.enqueue(object : Callback<UsersItem> {
            override fun onResponse(call: Call<UsersItem>, response: Response<UsersItem>) {
                onFinishedListener.onFinished(response.body())
            }

            override fun onFailure(call: Call<UsersItem>, t: Throwable) {
                onFinishedListener.onFailure(t)
            }
        })
    }
}