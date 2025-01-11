package com.elijahhezekiah.animeapp

import kotlinx.serialization.Serializable

sealed class Screen(val route: String) {
    data object TrendingAnimeRoute: Screen("trending_anime_screen")

}

//@Serializable
//data object TrendingAnimeRoute

@Serializable
data class AnimeRoute(val coverUrl: String, val id: String)