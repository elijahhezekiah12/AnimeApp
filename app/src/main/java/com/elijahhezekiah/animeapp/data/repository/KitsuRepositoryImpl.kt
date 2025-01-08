package com.elijahhezekiah.animeapp.data.repository

import android.util.Log
import com.elijahhezekiah.animeapp.data.KitsuApi
import com.elijahhezekiah.animeapp.data.dto.AnimeResponseDto
import com.elijahhezekiah.animeapp.data.dto.TrendingAnimeListDto
import com.elijahhezekiah.animeapp.domain.repository.KitsuRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess
import javax.inject.Inject

class KitsuRepositoryImpl @Inject constructor(
    private val api: KitsuApi
) : KitsuRepository {

    override suspend fun getTrendingAnime(): TrendingAnimeListDto? {
        Log.d("getTrendingAnime", "success")
       var animeData: TrendingAnimeListDto? =null

        api.getTrendingAnime().onSuccess {
            animeData = data
        }
        .onError {
                Log.d("getTrendingAnime", "error - ${this.message()}")
            }

         .onException {
                Log.d("getTrendingAnime", "exception - ${this.message}")
            }

        return animeData
    }

    override suspend fun getAnimeById(animeID: Int): AnimeResponseDto {
        return api.getAnimeById(animeID)
    }
}