package com.sample.githubusers.ui.users

import com.sample.githubusers.data.UsersItem
import com.sample.githubusers.data.network.UsersRepository

class UsersPresenter(_view: IUsersContract.IUsersView) : IUsersContract.IUsersPresenter, IUsersContract.IUsersRepository.OnFinishedListener {
    private var view: IUsersContract.IUsersView? = null

    init {
        this.view = _view
    }

    override fun getUsers(perPage: Int, since: Int) {
        UsersRepository().getUsers(perPage, since, this)
    }

    override fun onDestroy() {
        view = null
    }

    override fun onFinished(users: ArrayList<UsersItem>?) {
        view!!.onUsersResult(users)
    }

    override fun onFailure(t: Throwable?) {
        view!!.onResponseFailure(t!!)
    }
}