package com.josue.example.superherolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.josue.example.superherolist.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class HeroAdapter(val superhero: List<SuperHero>) : RecyclerView.Adapter<HeroAdapter.HeroHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(superhero[position])
    }

    override fun getItemCount(): Int = superhero.size

    class HeroHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemSuperheroBinding.bind(view)

        fun render(superhero: SuperHero) {
            binding.tvRealName.text = superhero.realName
            binding.tvSeuperHeroName.text = superhero.superHeroName
            binding.tvPublisher.text = superhero.publisher
            Picasso.get().load(superhero.image).into(binding.ivHero)
        }
    }
}