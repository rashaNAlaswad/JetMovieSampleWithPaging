package com.rns.jetmoviesamplewithpaging.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.rns.jetmoviesamplewithpaging.ui.composable.PagingState
import com.rns.jetmoviesamplewithpaging.ui.home.components.ItemMovie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val state by viewModel.moviesState.collectAsState()
    val pagingItems = state.allMovies.collectAsLazyPagingItems()

    Scaffold {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            items(pagingItems.itemCount) { index ->
                ItemMovie(pagingItems[index]!!)
            }
            item {
                PagingState(pagingItems, modifier = Modifier.fillParentMaxSize())
            }
        }
    }

}