package com.example.codesample.presentation.main

data class MainUiState(
    val scrollPosition: Int = 0,
)

sealed class MainUiAction {
    data class OnSaveScrollPosition(val position: Int): MainUiAction()
}