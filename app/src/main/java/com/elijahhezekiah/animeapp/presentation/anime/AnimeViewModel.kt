package com.elijahhezekiah.animeapp.presentation.anime

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.elijahhezekiah.animeapp.domain.model.AnimeData
import com.elijahhezekiah.animeapp.domain.use_case.GetAnimeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class AnimeViewModel @Inject constructor(
    private val getAnimeUseCase: GetAnimeUseCase
) : ViewModel() {

    private val _state = mutableStateOf(AnimeState())

    private var _anime = MutableStateFlow<AnimeData?>(null)

    val state: State<AnimeState> = _state

}