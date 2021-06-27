package com.sample.githubusers.ui.users

import com.sample.githubusers.data.UsersItem
import com.sample.githubusers.data.network.UsersRepositoryTest
import junit.framework.TestCase

class UsersPresenterTest : TestCase(), IUsersContract.IUsersRepository.OnFinishedListener {
    fun testGetUsers() {
        UsersRepositoryTest().getUsers(UsersActivity.KEY.PAGE_COUNT, 20, this)
    }

    override fun onFinished(users: ArrayList<UsersItem>?) {
        assertTrue(users != null)
    }

    override fun onFailure(t: Throwable?) {
        assertTrue(false)
    }
}