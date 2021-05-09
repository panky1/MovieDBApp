package com.example.movieappinfo.data.entity

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.movieappinfo.R


data class Movie(
    val adult: Boolean,
    val backdrop_path: String?,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
) {
    companion object {
        @JvmStatic
        @BindingAdapter("android:imageUri")
        fun bindImage(view: View, poster_path: String) {
            val image = view.findViewById<ImageView>(R.id.imageView)
            Glide.with(view)
                .load("https://image.tmdb.org/t/p/w500/${poster_path}")
                .thumbnail(Glide.with(view).load(R.drawable.ic_default))
                .into(image)
        }
    }
}