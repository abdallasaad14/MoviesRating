package com.example.moviesrating.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.moviesrating.adapter.MovieAdapter
import com.example.moviesrating.databinding.FragmentMainBinding
import com.example.moviesrating.viewModels.MainModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainModel by lazy {
        ViewModelProvider(this)[MainModel::class.java]
    }
    private val movieAdapter by lazy { MovieAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.filmsList.adapter = movieAdapter

        return binding.root
    }
}