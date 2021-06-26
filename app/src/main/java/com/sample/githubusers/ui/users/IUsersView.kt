package com.sample.githubusers.ui.users

import com.sample.githubusers.data.UsersItem

interface IUsersView {
    fun onResponseFailure(throwable: Throwable?)

    fun onUsersResult(users: ArrayList<UsersItem>?)
}