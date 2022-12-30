package com.josue.example.superherolist.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.josue.example.superherolist.SuperHero
import com.josue.example.superherolist.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view:View): RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)

    fun render(superHeroModel: SuperHero, onClickListener: (SuperHero) -> Unit){
        binding.tvRealName.text = superHeroModel.realName
        binding.tvSeuperHeroName.text = superHeroModel.superHeroName
        binding.tvPublisher.text = superHeroModel.publisher
        Picasso.get().load(superHeroModel.image).into(binding.ivHero)
        binding.ivHero.setOnClickListener {
            Toast.makeText(
                binding.ivHero.context,
                "Selecccionaste a ${superHeroModel.realName}",
                Toast.LENGTH_SHORT).show()
        }

        itemView.setOnClickListener { onClickListener(superHeroModel)}
    }
}