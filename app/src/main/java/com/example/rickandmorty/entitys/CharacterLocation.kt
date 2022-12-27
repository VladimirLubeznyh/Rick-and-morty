package com.example.rickandmorty.entitys

import com.google.gson.annotations.SerializedName

data class CharacterLocation(
    @SerializedName("name")val name:String,
)
