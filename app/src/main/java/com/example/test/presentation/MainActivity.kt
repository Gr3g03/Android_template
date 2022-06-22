package com.example.test.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.test.R
import com.example.test.databinding.ActivityMainBinding
import com.example.test.presentation.to_do.ToDoFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setUpBottomNavigation()

        setContentView(binding.root)
    }


    private fun setUpBottomNavigation() {
        val navHostFragment =
            supportFragmentManager
                .findFragmentById(binding.navHostFragmentActivityApp.id) as NavHostFragment?

        if (navHostFragment != null) navController = navHostFragment.navController
    }


}