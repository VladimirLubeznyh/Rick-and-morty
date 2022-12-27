package com.example.rickandmorty.entitys

import com.google.gson.annotations.SerializedName

data class CharactersList(
    @SerializedName("results") val results: List<Character>
)

