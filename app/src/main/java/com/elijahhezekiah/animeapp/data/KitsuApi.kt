package com.elijahhezekiah.animeapp.data

import com.elijahhezekiah.animeapp.data.dto.AnimeResponseDto
import com.elijahhezekiah.animeapp.data.dto.TrendingAnimeListDto
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface KitsuApi {
    @GET("trending/anime")
    suspend fun getTrendingAnime():  TrendingAnimeListDto

    @GET("anime/{id}")
    suspend fun getAnimeById(@Path("id") id: Int): AnimeResponseDto

}