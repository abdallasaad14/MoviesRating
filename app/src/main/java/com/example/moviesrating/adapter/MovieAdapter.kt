/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.moviesrating.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesrating.R
import com.example.moviesrating.databinding.FilmItemBinding
import com.example.moviesrating.refrences.MoviesList
import com.example.moviesrating.refrences.Result
import com.example.moviesrating.screens.MainFragmentDirections
import com.example.moviesrating.screens.utils.Constants.POSTER_BASEURL
import com.squareup.picasso.Picasso

/**
 * This class implements a [RecyclerView] [ListAdapter] which uses Data Binding to present [List]
 * data, including computing diffs between lists.
 */
class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    var data = emptyList<Result>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class MyViewHolder(val binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        return MyViewHolder(
            FilmItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data[position]
        holder.binding.apply {
            filmName.text = item.title
            filmRate.text = item.vote_average.toString()
            val moviePosterUrl = POSTER_BASEURL + item.poster_path
            Picasso.get().load(moviePosterUrl).into(filmImg)
            filmLanguage.text = item.original_language
            filmDate.text = item.release_date
        }
        holder.binding.cardItem.setOnClickListener {
            it.findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToDetailsFragment(item))
        }
    }
}

