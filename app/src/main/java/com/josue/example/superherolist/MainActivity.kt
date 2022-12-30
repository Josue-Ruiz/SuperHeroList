package com.josue.example.superherolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val superheros = listOf(
        SuperHero("Spidernman","Peter Parker","Peter Parker","https://superherol")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun initRecyclerView() {}
}