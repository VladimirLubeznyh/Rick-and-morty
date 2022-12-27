package com.example.rickandmorty.data

import retrofit2.http.GET
import retrofit2.http.Query

import com.example.rickandmorty.entitys.CharactersList

interface SearchCharacterApi {
    @GET("/api/character")
    suspend fun getCharacterList(@Query("page") page: Int): CharactersList
}