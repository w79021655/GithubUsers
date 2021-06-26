package com.sample.githubusers.ui.users

import com.sample.githubusers.data.UsersItem

interface IUsersContract {
    interface IUsersView {
        fun onResponseFailure(throwable: Throwable?)

        fun onUsersResult(users: ArrayList<UsersItem>?)
    }

    interface IUsersPresenter {

        fun getUsers(perPage: Int, since: Int)


    }

    interface IUsersRepository {

        interface OnFinishedListener {
            fun onFinished(users: ArrayList<UsersItem>?)

            fun onFailure(t: Throwable?)
        }

        fun getUsers(perPage: Int, since: Int, onFinishedListener: OnFinishedListener)
    }
}