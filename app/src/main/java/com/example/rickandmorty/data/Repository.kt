package com.example.rickandmorty.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmorty.entitys.Character
import kotlinx.coroutines.flow.Flow

class Repository(private val retrofit: RetrofitInit) {
    fun getPageDataFlow(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(20),
            pagingSourceFactory = { PagingDataSearch(retrofit) }
        ).flow
    }
}