package com.example.moviesrating.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.moviesrating.R
import com.example.moviesrating.databinding.FragmentDetailsBinding
import com.example.moviesrating.databinding.FragmentMainBinding
import com.example.moviesrating.screens.utils.Constants
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater)
        val args = DetailsFragmentArgs.fromBundle(requireArguments())
        val film = args.result
        val posterUrl = Constants.POSTER_BASEURL + film.poster_path
        binding.apply {
            detailsFilmName.text = "Name : ${film.original_title}"
            detailsFilmDate.text = "Date : ${film.release_date}"
            detailsFilmPopularity.text = "Popularity : ${film.popularity}"
            detailsFilmRating.text = "Rating : ${film.vote_average}"
            detailsFilmOverview.text = "Overview : ${film.overview}"
            Picasso.get().load(posterUrl).into(detailsFilmImg)
            Picasso.get().load(posterUrl).into(detailsFilmShadow)
            detailsFilmLanguage.text = "Language : ${film.original_language}"
        }

        return binding.root
    }
}
