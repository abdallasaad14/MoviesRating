package com.example.moviesrating.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesrating.api.ApiClient
import com.example.moviesrating.api.ApiService
import com.example.moviesrating.refrences.Result
import kotlinx.coroutines.launch

class MainModel:ViewModel() {
    private val api: ApiService by lazy { ApiClient().getClient().create(ApiService::class.java) }

    private val _films = MutableLiveData<List<Result>>()

    // The external immutable LiveData for the request status String
    val films: LiveData<List<Result>>
        get() = _films

    init {

        getFilms()
    }
    private fun getFilms() {
        viewModelScope.launch {
            val callMovieApi = api.getPopularMovies(2)
            try {
                val listResult = callMovieApi.await()
                _films.value = listResult.results

            } catch (_: Exception) {

            }
        }
    }

}