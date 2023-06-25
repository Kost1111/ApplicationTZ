package com.example.myapplication_tz.second_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication_tz.KEY_SUM
import com.example.myapplication_tz.R
import com.example.myapplication_tz.UsersAdapter.UsersAdapter
import com.example.myapplication_tz.users.Users
import com.example.myapplication_tz.base_fragment.BaseFragment
import com.example.myapplication_tz.databinding.FragmentSecondBinding
import com.example.myapplication_tz.first_fragment.FirstFragment
import com.example.myapplication_tz.response
import com.example.myapplication_tz.users.user.User
import com.google.gson.Gson

class SecondFragment : BaseFragment<FragmentSecondBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentSecondBinding =
        FragmentSecondBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = UsersAdapter()
        val gson = Gson()
        val users = gson.fromJson(response, Users::class.java)
        users.add(0, User("Возраст", "Имя"))
        adapter.submitList(users.toList())
        binding.apply {
            rvUsers.layoutManager = LinearLayoutManager(requireContext())
            rvUsers.adapter = adapter
            sumNumber.text = arguments?.getInt(KEY_SUM, 0).toString()
            backButton.setOnClickListener {
                goToFirstFragment()
            }
        }
    }

    private fun goToFirstFragment() {
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, FirstFragment())
            ?.commit()
    }
}