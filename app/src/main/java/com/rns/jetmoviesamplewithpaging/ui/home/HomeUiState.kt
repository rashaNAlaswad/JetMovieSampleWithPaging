package com.rns.jetmoviesamplewithpaging.ui.home

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class HomeUiState(
    val allMovies: Flow<PagingData<MovieUiState>> = emptyFlow(),
)