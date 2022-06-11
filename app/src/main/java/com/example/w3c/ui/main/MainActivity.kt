package com.example.w3c.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.w3c.ListHomeAdapter
import com.example.w3c.Post
import com.example.w3c.R
import com.example.w3c.databinding.ActivityBottomNavActicityBinding
import com.example.w3c.models.DummyData
import com.example.w3c.ui.login.LoginActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavActicityBinding
    private lateinit var rvHome: RecyclerView
    private var list: ArrayList<Post> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar!!.title= "Home"

        binding = ActivityBottomNavActicityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvHome = findViewById(R.id.nav_host_fragment_activity_main)
        rvHome.setHasFixedSize(true)

        list.addAll(DummyData.listData)
        showRecyclerList()

   


        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_bottom_nav_acticity)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_search,
                R.id.navigation_add,
                R.id.navigation_favorite,
                R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun showRecyclerList() {
        rvHome.layoutManager = LinearLayoutManager(this)
        val listHomeAdapter = ListHomeAdapter(list)
        rvHome.adapter = listHomeAdapter
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}