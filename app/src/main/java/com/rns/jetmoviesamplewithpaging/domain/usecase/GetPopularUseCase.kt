package com.rns.jetmoviesamplewithpaging.domain.usecase

import androidx.paging.PagingData
import androidx.paging.map
import com.rns.jetmoviesamplewithpaging.data.MovieRepository
import com.rns.jetmoviesamplewithpaging.data.mapper.toMovie
import com.rns.jetmoviesamplewithpaging.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPopularUseCase @Inject constructor(
    private val repository: MovieRepository,
) {

    suspend operator fun invoke(): Flow<PagingData<Movie>> {
        return repository.getPopularPager().flow.map { pagingData ->
            pagingData.map {
                it.toMovie()
            }
        }
    }
}