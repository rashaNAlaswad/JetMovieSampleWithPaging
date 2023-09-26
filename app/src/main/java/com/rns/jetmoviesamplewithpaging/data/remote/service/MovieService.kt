package com.rns.jetmoviewithpagingsample.data.remote.service

import com.rns.jetmoviesamplewithpaging.data.remote.response.movie.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int = 1): Response<MovieResponse>
}
