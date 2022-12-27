package com.example.rickandmorty.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.rickandmorty.databinding.ListFragmentBinding
import com.example.rickandmorty.ui.adapter.CharacterPageAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ListFragment : Fragment() {

    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<ListFragmentViewModel> { ViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = CharacterPageAdapter()

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), VERTICAL, false)

        setStateUi(adapter)
        observeLaunches(adapter)
        onClickRefreshBt(adapter)
    }

    private fun observeLaunches(adapter: CharacterPageAdapter) {
        viewModel.pagingDataFlow.onEach {
            adapter.submitData(it)
        }.launchIn(lifecycleScope)
    }

    private fun onClickRefreshBt(adapter: CharacterPageAdapter) {
        binding.refresh.setOnClickListener {
            adapter.refresh()
        }
    }

    private fun setStateUi(adapter: CharacterPageAdapter) {
        adapter.loadStateFlow.onEach {
            val refresh = it.refresh
            val append = it.append

            when {
                refresh is LoadState.Error -> {
                    setErrorState(refresh.error.message)
                }
                append is LoadState.Error -> {
                    setErrorState(append.error.message)
                }
                it.refresh is LoadState.Loading -> {
                    binding.loading.isGone = false
                    binding.refresh.isGone = true
                    binding.recyclerView.isGone = true
                }
                else -> {
                    binding.loading.isGone = true
                    binding.refresh.isGone = true
                    binding.recyclerView.isGone = false
                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun setErrorState(errorMessage: String?) {
        binding.loading.isGone = true
        binding.recyclerView.isGone = true
        binding.refresh.isGone = false
        Toast.makeText(requireContext(), "Ошибка: $errorMessage", Toast.LENGTH_LONG).show()
    }
}