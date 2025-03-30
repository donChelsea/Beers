package com.example.codesample.presentation.main

import androidx.paging.PagingData
import com.example.codesample.presentation.model.BeerUiModel

data class MainUiState(
    val beers: PagingData<BeerUiModel> = PagingData.empty(),
    val scrollPosition: Int = 0,
)

sealed class MainUiAction {
    data class OnSavePosition(val position: Int): MainUiAction()
}