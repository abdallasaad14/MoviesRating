package com.example.moviesrating

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesrating.adapter.MovieAdapter
import com.example.moviesrating.refrences.Result


 @BindingAdapter("list_it")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Result>?) {
    data?.let {
        val adapter = recyclerView.adapter as MovieAdapter
        adapter.data = data
    }
}