package com.josue.example.superherolist

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.josue.example.superherolist.adapter.SuperHeroAdapter
import com.josue.example.superherolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var superHeroMutableList: MutableList<SuperHero> =
        SuperHeroProvider.superheroList.toMutableList()
    private lateinit var adapter: SuperHeroAdapter
    private val lmanager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnaddSuper.setOnClickListener { createSuperHero() }
        configSwipe()
        configFilter()
        initRecyclerView()
    }

    private fun configSwipe() {
        binding.swipe.setColorSchemeColors(
            ResourcesCompat.getColor(
                resources,
                R.color.purple_500,
                null
            )
        )
        binding.swipe.setProgressBackgroundColorSchemeColor(
            ResourcesCompat.getColor(
                resources,
                R.color.teal_200,
                null
            )
        )

        binding.swipe.setOnRefreshListener {
            Log.i("ConfigSwipe", "onRefresh")
            Handler(Looper.getMainLooper()).postDelayed({
                binding.swipe.isRefreshing = false
            }, 2000)
        }
    }

    private fun configFilter() {
        binding.searchSuper.addTextChangedListener { userFilter ->
            val superherosFiltered = superHeroMutableList.filter { superhero ->
                superhero.superHeroName.lowercase().contains(userFilter.toString().lowercase())
            }
            adapter.updateSuperHero(superherosFiltered)
        }
    }

    private fun createSuperHero() {
        val url =
            "https://static.wikia.nocookie.net/lossimpson/images/1/16/Guy_Incognito.png/revision/latest?cb=20100401233011&path-prefix=es"
        val superHero = SuperHero(
            "Incognito",
            "Empresa Privada",
            "????????",
            url
        )
        superHeroMutableList.add(index = 3, superHero)
        adapter.notifyItemInserted(3)
        lmanager.scrollToPositionWithOffset(3, 20)

    }

    private fun initRecyclerView() {
        adapter = SuperHeroAdapter(
            superheroList = superHeroMutableList,
            onClickListener = { superHero -> onItemSelected(superHero) },
            onClickDelete = { position -> onDeleteItem(position) }
        )
        binding.rvSuperhero.layoutManager = lmanager
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