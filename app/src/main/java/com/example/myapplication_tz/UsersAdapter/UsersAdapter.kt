package com.example.myapplication_tz.UsersAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication_tz.R
import com.example.myapplication_tz.users.user.User


class UsersAdapter() :
    ListAdapter<User, UsersAdapter.UserViewHolder>(UserDiffUtil()) {

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(user: User) {
            val tvName: TextView = itemView.findViewById(R.id.name)
            val tvAge: TextView = itemView.findViewById(R.id.age)
            tvName.text = user.name
            tvAge.text = user.age
        }
    }

    companion object {
        class UserDiffUtil : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.users_item, parent, false)
        return UserViewHolder(view = view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.onBind(user)
    }
}