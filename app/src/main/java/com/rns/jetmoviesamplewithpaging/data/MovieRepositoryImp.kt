package com.rns.jetmoviesamplewithpaging.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.rns.jetmoviesamplewithpaging.data.paging.PopularDataSource
import com.rns.jetmoviesamplewithpaging.data.remote.response.movie.MovieDto
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val dataSource: PopularDataSource,
) : MovieRepository {

    private val config =
        PagingConfig(pageSize = PAGE_SIZE)

    override suspend fun getPopularPager(): Pager<Int, MovieDto> {
        return Pager(config = config,
            pagingSourceFactory = { dataSource })
    }

    companion object {
        private const val PAGE_SIZE = 10
    }
}