package com.example.movieappinfo.data.response

import com.example.movieappinfo.data.entity.Movie

data class MovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)