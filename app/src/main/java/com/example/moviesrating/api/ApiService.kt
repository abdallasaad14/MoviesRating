package com.example.moviesrating.api

import com.example.moviesrating.refrences.MoviesList
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("get_countries")
    fun getPopularMovies(@Query("page") page :Int):Call<MoviesList>
}
