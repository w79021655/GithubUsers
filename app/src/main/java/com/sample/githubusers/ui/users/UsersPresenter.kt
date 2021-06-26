package com.sample.githubusers.ui.users

import com.sample.githubusers.data.UsersItem
import com.sample.githubusers.data.network.UsersRepository

class UsersPresenter(_view: IUsersView) : IUsersPresenter, IUsersPresenter.OnFinishedListener {
    private var view: IUsersView? = null

    init {
        this.view = _view
    }

    override fun getUsers(perPage: Int, since: Int) {
        UsersRepository().getUsers(perPage, since, this)
    }

    override fun onFinished(users: ArrayList<UsersItem>?) {
        view!!.onUsersResult(users)
    }

    override fun onFailure(t: Throwable?) {
        view!!.onResponseFailure(t!!)
    }
}