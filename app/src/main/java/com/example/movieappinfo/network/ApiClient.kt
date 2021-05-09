package com.example.movieappinfo.network

import com.example.movieappinfo.data.response.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    companion object {
        const val POPULAR_MOVIES = "/3/movie/popular"
    }


    @GET(POPULAR_MOVIES)
    fun getPopularMovies(@Query("api_key") key: String): Observable<MovieResponse>


}