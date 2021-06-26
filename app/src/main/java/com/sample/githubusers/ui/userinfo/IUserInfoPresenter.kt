package com.sample.githubusers.ui.userinfo

import com.sample.githubusers.data.UsersItem


interface IUserInfoPresenter {

    fun getUserInfo(unerName:String)

    interface OnFinishedListener {
        fun onFinished(userItem: UsersItem?)

        fun onFailure(t: Throwable?)
    }
}