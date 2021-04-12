package com.example.resumie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.resumie.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        setHomeFragment()
    }

    fun setHomeFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()
    }
}

