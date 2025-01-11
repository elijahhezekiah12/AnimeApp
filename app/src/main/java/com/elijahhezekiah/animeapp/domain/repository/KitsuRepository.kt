package com.elijahhezekiah.animeapp.domain.repository

import com.elijahhezekiah.animeapp.data.dto.AnimeResponseDto
import com.elijahhezekiah.animeapp.data.dto.TrendingAnimeListDto
import com.elijahhezekiah.animeapp.domain.model.AnimeData
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface KitsuRepository {
    @GET("trending/anime")
    suspend fun getTrendingAnime():   TrendingAnimeListDto ?

    @GET("anime/{id}")
    suspend fun getAnimeById(@Path("id") id: Int): AnimeResponseDto

}