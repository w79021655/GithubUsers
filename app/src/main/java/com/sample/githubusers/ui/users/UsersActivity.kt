package com.sample.githubusers.ui.users

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.githubusers.data.UsersItem
import com.sample.githubusers.databinding.ActivityUsersBinding
import com.sample.githubusers.ui.adapter.UsersAdapter
import com.sample.githubusers.ui.userinfo.UserInfoActivity

class UsersActivity : AppCompatActivity(), IUsersContract.IUsersView {
    private lateinit var binding: ActivityUsersBinding
    private lateinit var mAdapter: UsersAdapter
    private lateinit var usersPresenter: UsersPresenter
    private var mUsers = ArrayList<UsersItem>()
    private var isNext = true
    private var since: Int = 0

    object KEY {
        const val LOGIN: String = "login"
        const val PAGE_COUNT: Int = 20
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usersPresenter = UsersPresenter(this)

        setupUI()
        fetchUsers(since)
    }

    override fun onDestroy() {
        super.onDestroy()
        usersPresenter.onDestroy()
    }

    private fun setupUI() {
        binding.recyclerView.apply {
            val layoutManager = LinearLayoutManager(this@UsersActivity)
            layoutManager.orientation = RecyclerView.VERTICAL
            binding.recyclerView.layoutManager = layoutManager
            mAdapter = UsersAdapter(listener)
            binding.recyclerView.adapter = mAdapter
        }

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange()) {
                    if (isNext)
                        fetchUsers(mUsers[mUsers.size - 1].id)
                }
            }
        })
    }

    private fun fetchUsers(since: Int) {
        binding.loading.visibility = View.VISIBLE
        usersPresenter.getUsers(KEY.PAGE_COUNT, since)
    }

    private var listener = object : UsersAdapter.OnItemClickListener {
        override fun onItemClick(login: String) {
            val intent = Intent()
            val bundle = Bundle()
            bundle.putString(KEY.LOGIN, login)
            intent.setClass(this@UsersActivity, UserInfoActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    override fun onUsersResult(users: ArrayList<UsersItem>?) {
        runOnUiThread {
            binding.loading.visibility = View.GONE
            if (users != null) {
                if (users.size == 0) {
                    isNext = false
                } else {
                    mUsers.addAll(users)
                    mAdapter.setUsers(mUsers)
                    mAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onResponseFailure(throwable: Throwable?) {
        binding.loading.visibility = View.GONE
    }
}