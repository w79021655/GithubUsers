package com.sample.githubusers.ui.userinfo

import com.sample.githubusers.data.UsersItem
import com.sample.githubusers.data.network.UserInfoRepositoryTest
import junit.framework.TestCase

class UserInfoPresenterTest : TestCase(), IUserInfoContract.IUserInfoRepository.OnFinishedListener {

    fun testGetUserInfo() {
        UserInfoRepositoryTest().getUserInfo("unerName", this)
    }

    override fun onFinished(userItem: UsersItem?) {
        assertTrue(userItem != null)
    }

    override fun onFailure(t: Throwable?) {
        assertTrue(false)
    }
}