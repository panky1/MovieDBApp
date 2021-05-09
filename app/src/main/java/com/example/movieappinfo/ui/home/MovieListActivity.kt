package com.example.movieappinfo.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieappinfo.App
import com.example.movieappinfo.R
import com.example.movieappinfo.databinding.ActivityMovieListBinding
import com.example.movieappinfo.di.component.DaggerApplicationComponent
import com.example.movieappinfo.ui.adapter.MovieListItemAdapter
import com.example.movieappinfo.util.hide
import com.example.movieappinfo.util.show
import com.example.movieappinfo.util.snackbar
import javax.inject.Inject

class MovieListActivity : AppCompatActivity(), MovieListener {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivityMovieListBinding
    private val homeAdapter by lazy {
        MovieListItemAdapter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerApplicationComponent.factory().create(this.application as App).inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_list)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MovieListViewModel::class.java)
        binding.viewModel = viewModel
        binding.progressBar.show()
        viewModel.getMovie()
        viewModel.movies.observe(this, Observer { movies ->
            binding.progressBar.hide()
            binding.movieRecyclerView.apply {
                setHasFixedSize(true)
                layoutManager =
                    GridLayoutManager(this@MovieListActivity,2, GridLayoutManager.VERTICAL, false)
                adapter = homeAdapter
                homeAdapter.addItems(movies)
            }
        })
    }


    override fun onFetchStarted() {
        binding.progressBar.show()
    }


    override fun onFetchFinished() {
        binding.progressBar.visibility = View.GONE
        binding.progressBar.hide()
    }

    override fun onFailure(message: String) {
        binding.progressBar.hide()
        binding.root.snackbar(message)
    }
}