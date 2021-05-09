package com.example.movieappinfo.network

import com.example.movieappinfo.data.response.*
import com.example.movieappinfo.util.annotations.Tmdb
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiService @Inject constructor(@Tmdb retrofit: Retrofit) : ApiClient {
    private val api by lazy {
        retrofit.create(ApiClient::class.java)
    }


    override fun getPopularMovies(key: String): Observable<MovieResponse> {
        return api.getPopularMovies(key)
    }


}