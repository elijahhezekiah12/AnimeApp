package com.elijahhezekiah.animeapp.presentation.trending_anime

import com.elijahhezekiah.animeapp.domain.model.AnimeData

data class AnimeListState(
    val isLoading: Boolean = false,
    var trendingAnimeList: List<AnimeData> = emptyList(),
    val error: String = ""
)