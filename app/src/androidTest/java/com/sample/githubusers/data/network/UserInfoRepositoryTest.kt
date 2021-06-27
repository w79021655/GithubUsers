package com.sample.githubusers.data.network

import com.sample.githubusers.data.UsersItem
import com.sample.githubusers.ui.userinfo.IUserInfoContract

class UserInfoRepositoryTest : IUserInfoContract.IUserInfoRepository {
    override fun getUserInfo(unerName: String, onFinishedListener: IUserInfoContract.IUserInfoRepository.OnFinishedListener) {
        onFinishedListener.onFinished(
            UsersItem(
                "https://avatars.githubusercontent.com/u/1?v=4",
                null,
                "http://tom.preston-werner.com",
                "@chatterbugapp, @redwoodjs, @preston-werner-ventures ",
                "2007-10-20T05:24:19Z",
                null,
                "https://api.github.com/users/mojombo/events{/privacy}",
                22579,
                "https://api.github.com/users/mojombo/followers",
                11,
                "https://api.github.com/users/mojombo/following{/other_user}",
                "https://api.github.com/users/mojombo/gists{/gist_id}",
                "https://api.github.com/users/mojombo/orgs",
                "https://api.github.com/users/mojombo/repos",
                "https://api.github.com/users/mojombo/events{/privacy}",
                1,
                "San Francisco",
                "mojombo",
                "Tom Preston-Werner",
                "MDQ6VXNlcjE=",
                "https://api.github.com/users/mojombo/orgs",
                62,
                62,
                "https://api.github.com/users/mojombo/received_events",
                "https://api.github.com/users/mojombo/repos",
                false,
                "https://api.github.com/users/mojombo/starred{/owner}{/repo}",
                "https://api.github.com/users/mojombo/subscriptions",
                "mojombo",
                "User",
                "2021-06-10T20:43:31Z",
                "https://api.github.com/users/mojombo"
            )
        )
    }
}