package com.example.codesample.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.codesample.domain.repository.BeerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: BeerRepository
): ViewModel() {

    val beerFlow = repository.beerFlow().cachedIn(viewModelScope)
}