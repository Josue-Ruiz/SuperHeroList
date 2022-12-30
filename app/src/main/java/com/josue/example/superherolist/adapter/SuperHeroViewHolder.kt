package com.josue.example.superherolist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.josue.example.superherolist.SuperHero
import com.josue.example.superherolist.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view:View): RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)

    fun render(superHero: SuperHero){
        binding.tvRealName.text = superHero.realName
        binding.tvSeuperHeroName.text = superHero.superHeroName
        binding.tvPublisher.text = superHero.publisher
        Picasso.get().load(superHero.image).into(binding.ivHero)
//        binding.root.setOnClickListener {
//            Toast.makeText(view.context, "Selecccionaste a ${superhero.superHeroName}", Toast.LENGTH_SHORT).show()
//        }
    }
}