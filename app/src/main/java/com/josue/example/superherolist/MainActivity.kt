package com.josue.example.superherolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.josue.example.superherolist.adapter.SuperHeroAdapter
import com.josue.example.superherolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        val adapater =  SuperHeroAdapter(SuperHeroProvider.superheroList){
            superHero ->
            onItemSelected(
                superHero
            )
        }
        binding.rvSuperhero.adapter = adapater
    }

    fun onItemSelected(superHero: SuperHero){
        Toast.makeText(this,superHero.superHeroName,Toast.LENGTH_SHORT).show()
    }
}