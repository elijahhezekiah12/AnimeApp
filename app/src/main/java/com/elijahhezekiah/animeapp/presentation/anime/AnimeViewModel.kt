package com.elijahhezekiah.animeapp.presentation.anime

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elijahhezekiah.animeapp.common.Constants
import com.elijahhezekiah.animeapp.common.Resource
import com.elijahhezekiah.animeapp.domain.model.AnimeData
import com.elijahhezekiah.animeapp.domain.use_case.GetAnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val getAnimeUseCase: GetAnimeUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(AnimeState())

    private var _anime = MutableStateFlow<AnimeData?>(null)

    val state: State<AnimeState> = _state

    init {

    }

    fun getAnime(animeID: Int) {
        getAnimeUseCase(animeID).onEach { result ->

            when (result) {
                is Resource.Success -> {
                    _anime.update { result.data }
                    _state.value = AnimeState(anime = result.data )

                }
                is Resource.Error -> {

                    _anime.update { result.data }
                    _state.value = AnimeState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }

                is Resource.Loading -> {

                    _state.value = AnimeState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

}