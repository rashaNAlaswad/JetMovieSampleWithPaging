package com.rns.jetmoviesamplewithpaging.data.remote.response.movie

import com.google.gson.annotations.SerializedName
import com.rns.jetmoviesamplewithpaging.data.remote.response.movie.Dates
import com.rns.jetmoviesamplewithpaging.data.remote.response.movie.MovieDto

data class MovieResponse(
    @SerializedName("dates")
    val dates: Dates?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<MovieDto>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)