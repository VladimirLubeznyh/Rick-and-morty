package com.example.rickandmorty.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.CharacterItemBinding
import com.example.rickandmorty.entitys.Character

class CharacterViewHolder(private val binding: CharacterItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Character) {
        binding.run {
            nameText.text = item.name
            locationText.text = item.location.name
            statusAndRace.text =
                itemView.context.getString(R.string.status_and_race, item.status, item.gender)
            statusImage.setImageResource(
                when (item.status) {
                    "Alive" -> R.drawable.ic_alive
                    "Dead" -> R.drawable.ic_dead
                    else -> R.drawable.ic_unknown
                }
            )
            Glide
                .with(itemView.context)
                .load(item.image)
                .centerCrop()
                .into(image)
        }
    }
}