package com.sample.githubusers.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.githubusers.R
import com.sample.githubusers.data.UsersItem

class UsersAdapter(_listener: OnItemClickListener) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {
    private var mContext: Context? = null
    private var listener = _listener
    private var list = ArrayList<UsersItem>()

    interface OnItemClickListener {
        fun onItemClick(login: String)
    }

    fun setUsers(list: ArrayList<UsersItem>) {
        this.list = list
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        mContext = parent.context.applicationContext
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.cell_user, parent, false)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val usersItem = list[position]
        Glide.with(mContext!!).load(usersItem.avatarUrl).centerCrop().into(holder.avatar)
        holder.login.text = usersItem.login

        if (usersItem.siteAdmin) {
            holder.badge.visibility = View.VISIBLE
        } else {
            holder.badge.visibility = View.GONE
        }

        holder.layout.setOnClickListener {
            listener.onItemClick(usersItem.login)
        }
    }

    inner class UsersViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var layout: ConstraintLayout = itemView!!.findViewById(R.id.layout)
        var avatar: ImageView = itemView!!.findViewById(R.id.avatar)
        var login: TextView = itemView!!.findViewById(R.id.login)
        var badge: TextView = itemView!!.findViewById(R.id.badge)
    }
}