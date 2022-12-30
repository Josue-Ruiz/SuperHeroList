package com.josue.example.superherolist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.josue.example.superherolist.adapter.SuperHeroAdapter
import com.josue.example.superherolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var superHeroMutableList: MutableList<SuperHero> =
        SuperHeroProvider.superheroList.toMutableList()
    private lateinit var adapter: SuperHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = SuperHeroAdapter(
            superheroList = superHeroMutableList,
            onClickListener = { superHero -> onItemSelected(superHero) },
            onClickDelete = {position -> onDeleteItem(position)}
        )
        val manager = LinearLayoutManager(this)
        binding.rvSuperhero.layoutManager = manager
        binding.rvSuperhero.adapter = adapter
    }

    private fun onDeleteItem(position: Int) {
        superHeroMutableList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

    private fun onItemSelected(superHero: SuperHero) {
        Toast.makeText(this, superHero.superHeroName, Toast.LENGTH_SHORT).show()
    }
}