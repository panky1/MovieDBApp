package com.example.movieappinfo.repository

import com.example.movieappinfo.data.response.MovieResponse
import com.example.movieappinfo.network.ApiService
import io.reactivex.Observable
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val service: ApiService
) {


    fun getPopularMovies(key: String): Observable<MovieResponse> {
        return service.getPopularMovies(key)
    }
}