package com.example.rickandmorty.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmorty.data.Repository
import kotlinx.coroutines.flow.Flow
import com.example.rickandmorty.entitys.Character

class ListFragmentViewModel(repository: Repository) : ViewModel() {

    val pagingDataFlow: Flow<PagingData<Character>> =
        repository.getPageDataFlow().cachedIn(viewModelScope)

}
