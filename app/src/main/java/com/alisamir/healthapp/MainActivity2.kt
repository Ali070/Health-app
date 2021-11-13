package com.alisamir.healthapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.alisamir.healthapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var controller: NavController
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        controller = findNavController(R.id.fragmentContainerView2)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home,R.id.nav_Calculate,R.id.nav_person))
        setupActionBarWithNavController(controller,appBarConfiguration)
        NavigationUI.setupWithNavController(binding.navbottom, controller)

    }
}