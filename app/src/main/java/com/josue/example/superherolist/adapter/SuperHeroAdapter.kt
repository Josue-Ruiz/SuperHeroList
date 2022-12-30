package com.josue.example.superherolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.josue.example.superherolist.R
import com.josue.example.superherolist.SuperHero

class SuperHeroAdapter(private val superheroList:List<SuperHero>) : RecyclerView.Adapter<SuperHeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superheroList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = superheroList.size

//    class HeroHolder(val view: View) : RecyclerView.ViewHolder(view) {
//        val binding = ItemSuperheroBinding.bind(view)
//
//        fun render(superhero: SuperHero) {
//            binding.tvRealName.text = superhero.realName
//            binding.tvSeuperHeroName.text = superhero.superHeroName
//            binding.tvPublisher.text = superhero.publisher
//            Picasso.get().load(superhero.image).into(binding.ivHero)
//            binding.root.setOnClickListener {
//                Toast.makeText(view.context, "Selecccionaste a ${superhero.superHeroName}", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}