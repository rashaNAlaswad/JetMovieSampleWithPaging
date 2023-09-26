package com.rns.jetmoviesamplewithpaging.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.rns.jetmoviesamplewithpaging.data.mapper.toMovieUiState
import com.rns.jetmoviesamplewithpaging.domain.usecase.GetPopularUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getPopularUseCase: GetPopularUseCase) :
    ViewModel() {

    private val _moviesState = MutableStateFlow(HomeUiState())
    val moviesState get() = _moviesState.asStateFlow()

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            val allMovie = getPopularUseCase.invoke().map { pager ->
                pager.map { it.toMovieUiState() }
            }.cachedIn(viewModelScope)

            _moviesState.update { it.copy(allMovies = allMovie) }
        }
    }
}