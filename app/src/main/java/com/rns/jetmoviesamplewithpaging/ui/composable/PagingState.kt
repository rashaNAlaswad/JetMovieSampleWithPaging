package com.rns.jetmoviesamplewithpaging.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems

@Composable
fun <T : Any> PagingState(
    items: LazyPagingItems<T>,
    modifier: Modifier,
) {
    when {
        items.loadState.refresh is LoadState.Loading -> {
            Loading(
                modifier = modifier
            )
        }

        items.loadState.refresh is LoadState.Error -> {
            val error = items.loadState.refresh as LoadState.Error
            ErrorConnection(
                modifier = modifier,
                message = error.error.localizedMessage,
                onClickRetry = { items.retry() })

        }

        items.loadState.append is LoadState.Loading -> {
            LoadingNextPageItem(modifier = Modifier)
        }

        items.loadState.append is LoadState.Error -> {
            val error = items.loadState.append as LoadState.Error
            ErrorConnection(
                modifier = Modifier,
                message = error.error.localizedMessage,
                onClickRetry = { items.retry() })

        }
    }
}
