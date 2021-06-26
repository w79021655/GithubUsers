package com.sample.githubusers.ui.userinfo

import com.sample.githubusers.data.UsersItem

interface IUserInfoContract {
    interface IUserInfoView {
        fun onResponseFailure(throwable: Throwable?)

        fun onUserInfoResult(userItem: UsersItem?)
    }

    interface IUserInfoPresenter {

        fun getUserInfo(unerName:String)

    }

    interface IUserInfoRepository {

        interface OnFinishedListener {
            fun onFinished(userItem: UsersItem?)

            fun onFailure(t: Throwable?)
        }

        fun getUserInfo(unerName:String, onFinishedListener: OnFinishedListener)
    }
}