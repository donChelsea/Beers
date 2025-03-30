package com.example.codesample.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.codesample.domain.repository.BeerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: BeerRepository
) : ViewModel() {

    val beerFlow = repository
        .beerFlow()
        .cachedIn(viewModelScope)
        .transform { pagingData ->
            val transformedData = pagingData.map { it.toUiModel() }
            emit(transformedData)
        }
}