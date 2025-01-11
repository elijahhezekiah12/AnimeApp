package com.elijahhezekiah.animeapp.presentation.trending_anime

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elijahhezekiah.animeapp.common.Resource
import com.elijahhezekiah.animeapp.domain.use_case.GetTrendingAnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TrendingAnimeViewModel @Inject constructor(
    private val getTrendingAnimeUseCase: GetTrendingAnimeUseCase
) : ViewModel() {

    private val _state = mutableStateOf(AnimeListState())
    val state: State<AnimeListState> = _state


    init {
        getTrendingAnime()
    }

    private fun getTrendingAnime(){
        getTrendingAnimeUseCase().onEach { result ->

            when(result) {
                is Resource.Success -> {
                    _state.value = AnimeListState(trendingAnimeList = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = AnimeListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = AnimeListState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}