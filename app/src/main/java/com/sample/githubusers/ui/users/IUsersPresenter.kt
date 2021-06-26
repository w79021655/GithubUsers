package com.sample.githubusers.ui.users

import com.sample.githubusers.data.UsersItem


interface IUsersPresenter {

    fun getUsers(perPage: Int, since: Int)

     interface OnFinishedListener {
        fun onFinished(users: ArrayList<UsersItem>?)

        fun onFailure(t: Throwable?)
    }
}