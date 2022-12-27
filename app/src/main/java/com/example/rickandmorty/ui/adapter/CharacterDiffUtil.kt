package com.example.rickandmorty.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmorty.entitys.Character

class CharacterDiffUtil : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean =
        oldItem == newItem

}