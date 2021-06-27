package com.sample.githubusers.ui.userinfo

import com.sample.githubusers.data.UsersItem
import com.sample.githubusers.data.network.UserInfoRepository


class UserInfoPresenter(_view: IUserInfoContract.IUserInfoView) : IUserInfoContract.IUserInfoPresenter, IUserInfoContract.IUserInfoRepository.OnFinishedListener {
    private var view: IUserInfoContract.IUserInfoView? = null

    init {
        this.view = _view
    }

    override fun getUserInfo(unerName: String) {
       UserInfoRepository().getUserInfo(unerName, this)
    }

    override fun onDestroy() {
        view = null
    }

    override fun onFinished(userItem: UsersItem?) {
        view!!.onUserInfoResult(userItem!!)
    }

    override fun onFailure(t: Throwable?) {
        view!!.onResponseFailure(t!!)
    }
}