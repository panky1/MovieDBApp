package com.example.movieappinfo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieappinfo.data.entity.Movie
import com.example.movieappinfo.di.ui.BaseViewModel
import com.example.movieappinfo.repository.HomeRepository
import com.example.movieappinfo.util.api_key
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieListViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    BaseViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies
    private var homeListener: MovieListener? = null


    fun getMovie() {
        compositeDisposable.add(
            homeRepository.getPopularMovies(api_key)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { homeListener?.onFetchStarted() }
                .doOnTerminate { homeListener?.onFetchFinished() }
                .doOnComplete { homeListener?.onFetchFinished() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ movie ->
                            val movieResponse = movie.results
                            _movies.value = movieResponse
                        }, {
                            homeListener?.onFailure(it.localizedMessage!!)
                        })
        )
    }
}