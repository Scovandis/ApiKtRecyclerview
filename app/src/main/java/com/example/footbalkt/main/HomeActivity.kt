package com.example.footbalkt.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.footbalkt.R
import com.example.footbalkt.R.id.favorite
import com.example.footbalkt.R.id.teams
import com.example.footbalkt.R.layout.activity_home
import com.example.footbalkt.main.fragment.FavoriteFragment
import com.example.footbalkt.main.fragment.TeamsFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_home)

        bottom_navigation.setOnNavigationItemSelectedListener {item ->
            when(item.itemId){
                teams -> {
                    loadTeamsFragment(savedInstanceState)
                }
                favorite -> {
                    loadFavoriteFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = teams
    }
    private fun loadTeamsFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, TeamsFragment(), TeamsFragment::class.java.simpleName)
                .commit()
        }
    }
    private fun loadFavoriteFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, FavoriteFragment(), FavoriteFragment::class.java.simpleName)
                .commit()
        }
    }


}