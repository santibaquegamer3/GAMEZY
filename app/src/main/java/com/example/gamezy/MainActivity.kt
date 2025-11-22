package com.example.gamezy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.gamezy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        try {
            Log.d("MainActivity", "Starting MainActivity")
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            Log.d("MainActivity", "Layout set successfully")

            replaceFragment(HomeFragment())
            Log.d("MainActivity", "HomeFragment added")

            binding.bottomNavigation.setOnItemSelectedListener { item ->
                Log.d("MainActivity", "Navigation item selected: ${item.itemId}")
                when (item.itemId) {
                    R.id.nav_home -> replaceFragment(HomeFragment())
                    R.id.nav_search -> replaceFragment(SearchFragment())
                    R.id.nav_favorites -> replaceFragment(FavoritesFragment())
                    R.id.nav_read_later -> replaceFragment(ReadLaterFragment())
                }
                true
            }
            Log.d("MainActivity", "MainActivity created successfully")
        } catch (e: Exception) {
            Log.e("MainActivity", "Error in onCreate", e)
            throw e
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        try {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            Log.d("MainActivity", "Fragment replaced: ${fragment.javaClass.simpleName}")
        } catch (e: Exception) {
            Log.e("MainActivity", "Error replacing fragment", e)
        }
    }
}
