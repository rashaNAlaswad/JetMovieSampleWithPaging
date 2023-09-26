package com.rns.jetmoviesamplewithpaging.data

import androidx.paging.Pager
import com.rns.jetmoviesamplewithpaging.data.remote.response.movie.MovieDto

interface MovieRepository {

    suspend fun getPopularPager(): Pager<Int, MovieDto>
}
