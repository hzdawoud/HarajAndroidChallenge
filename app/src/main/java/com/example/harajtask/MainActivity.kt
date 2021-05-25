package com.example.harajtask

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController

import com.example.harajtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        getSupportActionBar()!!.setDisplayShowTitleEnabled(false);
        //toolbar.setNavigationIcon(R.drawable.ic_toolbar);
//        binding.toolbar.setTitle("");
//        binding.toolbar.setSubtitle("");

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        navController.addOnDestinationChangedListener{ _: NavController, destination: NavDestination, _: Bundle? ->
            if (destination.id == R.id.postListFragment) {
                binding.toolbar.setNavigationIcon(R.drawable.ic_search);
            } else {
                binding.toolbar.setNavigationIcon(R.drawable.ic_share);
            }

        }
    }
}