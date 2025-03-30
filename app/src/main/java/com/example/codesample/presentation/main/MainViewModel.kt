package com.example.codesample.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.codesample.domain.repository.BeerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: BeerRepository
) : ViewModel() {

    private val _state: MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState())
    val state: StateFlow<MainUiState>
        get() = _state.asStateFlow()

    val beerFlow = repository
        .getBeerFlow()
        .cachedIn(viewModelScope)
        .transform { pagingData ->
            val transformedData = pagingData.map { it.toUiModel() }
            emit(transformedData)
        }

    fun handleAction(action: MainUiAction) {
        when (action) {
            is MainUiAction.OnSaveScrollPosition -> _state.update { it.copy(scrollPosition = action.position) }
        }
    }
}