package com.example.codesample.presentation.main.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.codesample.presentation.custom.BeerItem
import com.example.codesample.presentation.custom.ErrorIndicator
import com.example.codesample.presentation.custom.LoadingIndicator
import com.example.codesample.presentation.main.MainUiAction
import com.example.codesample.presentation.main.MainViewModel
import com.example.codesample.presentation.model.BeerUiModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel<MainViewModel>(),
) {
    val state by viewModel.state.collectAsState()
    val beers: LazyPagingItems<BeerUiModel> = viewModel.beerFlow.collectAsLazyPagingItems()
    val context = LocalContext.current
    val lazyListState = rememberLazyListState()

    LaunchedEffect(lazyListState) {
        lazyListState.animateScrollToItem(state.scrollPosition)

        snapshotFlow {
            lazyListState.firstVisibleItemIndex
        }
            .collectLatest { index ->
                viewModel.handleAction(MainUiAction.OnSavePosition(index))
            }
    }

    LaunchedEffect(key1 = beers.loadState) {
        if (beers.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: ${(beers.loadState.refresh as LoadState.Error).error.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    LazyColumn(
        modifier = modifier,
        state = lazyListState,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(
            count = beers.itemCount,
            key = { it }
        ) { index ->
            val beer = beers[index]
            beer?.let {
                BeerItem(it)
            }
        }

        // Handle loading and error states
        when (beers.loadState.refresh) {
            is LoadState.Loading -> {
                item {
                    LoadingIndicator(text = "Loading beers...")
                }
            }

            is LoadState.Error -> {
                item {
                    ErrorIndicator(message = "Error loading data. Please try again.")
                }
            }

            else -> {}
        }

        when (beers.loadState.append) {
            is LoadState.Loading -> {
                item {
                    LoadingIndicator(text = "Loading more beers...")
                }
            }

            is LoadState.Error -> {
                item {
                    ErrorIndicator(message = "Error loading more data.")
                }
            }

            else -> {}
        }
    }
}