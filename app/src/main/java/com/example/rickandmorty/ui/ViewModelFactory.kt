package com.example.rickandmorty.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.data.Repository
import com.example.rickandmorty.data.RetrofitInit

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListFragmentViewModel::class.java)) {
            return ListFragmentViewModel(Repository(RetrofitInit)) as T
        } else {
            throw  IllegalArgumentException(
                "Unknown class name"
            )
        }
    }
}