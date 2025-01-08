package com.elijahhezekiah.animeapp.presentation.anime

import com.elijahhezekiah.animeapp.domain.model.AnimeData

data class AnimeState(
    val isLoading: Boolean = false,
    var coins: List<AnimeData> = emptyList(),
    val error: String = ""
)
