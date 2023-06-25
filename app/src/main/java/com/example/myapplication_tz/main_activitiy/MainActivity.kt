package com.example.myapplication_tz.main_activitiy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication_tz.R
import com.example.myapplication_tz.databinding.ActivityMainBinding
import com.example.myapplication_tz.first_fragment.FirstFragment

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, FirstFragment())
            .commit()
    }
}