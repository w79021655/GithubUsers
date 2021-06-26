package com.sample.githubusers.ui.userinfo

import com.sample.githubusers.data.UsersItem

interface IUserInfoView {
    fun onResponseFailure(throwable: Throwable?)

    fun onUserInfoResult(userItem: UsersItem?)
}