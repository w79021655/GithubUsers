package com.sample.githubusers.data.network

import com.sample.githubusers.data.Users
import com.sample.githubusers.ui.users.IUsersContract

class UsersRepositoryTest: IUsersContract.IUsersRepository {

    override fun getUsers(perPage: Int, since: Int, onFinishedListener: IUsersContract.IUsersRepository.OnFinishedListener) {
        onFinishedListener.onFinished(Users())
    }
}