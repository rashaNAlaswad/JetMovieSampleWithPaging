package com.rns.jetmoviesamplewithpaging.data.paging

import com.rns.jetmoviesamplewithpaging.data.remote.response.movie.MovieDto
import com.rns.jetmoviewithpagingsample.data.remote.service.MovieService
import javax.inject.Inject

class PopularDataSource @Inject constructor(
    private val service: MovieService,
) : BasePagingSource<MovieDto>() {
    override suspend fun fetchData(page: Int): List<MovieDto> {
        return service.getPopularMovies(page).body()?.results ?: emptyList()
    }
}