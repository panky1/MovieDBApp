package com.example.movieappinfo.ui.adapter

import com.example.movieappinfo.R
import com.example.movieappinfo.data.entity.Movie
import com.example.movieappinfo.databinding.MovieItemBinding
import com.example.movieappinfo.di.ui.BaseRecyclerViewAdapter

class MovieListItemAdapter : BaseRecyclerViewAdapter<Movie, MovieItemBinding>() {


    override fun getLayout(): Int {
        return R.layout.movie_item
    }


    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<MovieItemBinding>,
        position: Int
    ) {
        holder.binding.movie = items[position]
        holder.binding.root.setOnClickListener {
            listener?.invoke(it, items[position], position)
        }
    }
}