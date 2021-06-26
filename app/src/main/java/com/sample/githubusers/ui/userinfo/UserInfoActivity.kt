package com.sample.githubusers.ui.userinfo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.bumptech.glide.Glide
import com.sample.githubusers.data.UsersItem
import com.sample.githubusers.databinding.ActivityUserInfoBinding
import com.sample.githubusers.ui.users.UsersActivity

class UserInfoActivity : AppCompatActivity(), IUserInfoView {
    private lateinit var binding: ActivityUserInfoBinding
    private var login: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        login = intent.extras!!.getString(UsersActivity.KEY.LOGIN)

        binding.loading.visibility = View.VISIBLE
        Thread(Runnable {
            val usersPresenter = UserInfoPresenter(this)
            usersPresenter.getUserInfo(login!!)
        }).start()

        binding.close.setOnClickListener {
            finish()
        }
    }

    override fun onUserInfoResult(userItem: UsersItem?) {
        runOnUiThread {
            binding.loading.visibility = View.GONE
            Glide.with(this).load(userItem!!.avatarUrl).into(binding.avatar)
            binding.name.text = userItem.name
            binding.login.text = userItem.login
            binding.location.text = userItem.location

            if (userItem.siteAdmin) {
                binding.badge.visibility = View.VISIBLE
            } else {
                binding.badge.visibility = View.GONE
            }

            val blogLink = "<a href='" + userItem.blog + "'>" + userItem.blog + "</a>"
            binding.blog.text = HtmlCompat.fromHtml(blogLink, HtmlCompat.FROM_HTML_MODE_COMPACT)
        }
    }

    override fun onResponseFailure(throwable: Throwable?) {
        binding.loading.visibility = View.GONE
    }
}