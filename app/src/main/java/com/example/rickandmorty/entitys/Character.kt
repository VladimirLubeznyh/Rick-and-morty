package com.example.rickandmorty.entitys

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("id") val id:Int,
    @SerializedName("name") val name:String,
    @SerializedName("status") val status:String,
    @SerializedName("species") val species:String,
    @SerializedName("type") val type:String,
    @SerializedName("gender") val gender:String,
    @SerializedName("location") val location:CharacterLocation,
    @SerializedName("image") val image:String,
)
