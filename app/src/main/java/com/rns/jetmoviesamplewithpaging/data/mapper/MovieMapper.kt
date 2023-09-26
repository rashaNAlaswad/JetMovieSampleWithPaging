package com.rns.jetmoviesamplewithpaging.data.mapper

import com.rns.jetmoviesamplewithpaging.data.remote.response.movie.MovieDto
import com.rns.jetmoviesamplewithpaging.ui.home.MovieUiState
import com.rns.jetmoviesamplewithpaging.utils.Constant.IMAGE_BASE_PATH
import com.rns.jetmoviesamplewithpaging.domain.model.Movie

fun MovieDto.toMovie(): Movie {
    return Movie(
        id = id ?: 0,
        title = title ?: "",
        rating = voteAverage ?: 0.0,
        imageUrl = IMAGE_BASE_PATH + posterPath
    )
}

fun Movie.toMovieUiState(): MovieUiState {
    return MovieUiState(
        id = id,
        title = title,
        rating = rating,
        imageUrl = imageUrl
    )
}