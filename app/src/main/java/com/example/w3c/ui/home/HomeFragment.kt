package com.example.w3c.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.w3c.ListHomeAdapter
import com.example.w3c.Post
import com.example.w3c.R


class HomeFragment : Fragment() {

    private lateinit var rvHome: RecyclerView
    private var list: ArrayList<Post> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar!!.title= "Home"

        rvHome = findViewById(R.id.rv_freelancer)
        rvHome.setHasFixedSize(true)

        list.addAll(FreelancerData.listData)
        showRecyclerList()


        bottomAppBar.replaceMenu(R.menu.bottom_nav_menu)

        bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuAbout -> {
                    val intentAbout = Intent(this@MainActivity, AboutActivity::class.java)
                    startActivity(intentAbout)
                }
            }; true
        }
    }

    private fun showRecyclerList() {
        rvHome.layoutManager = LinearLayoutManager(this)
        val listHomeAdapter = ListHomeAdapter(list)
        rvHome.adapter = listHomeAdapter
    }
}
