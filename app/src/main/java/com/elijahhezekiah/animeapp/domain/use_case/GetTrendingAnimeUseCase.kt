package com.elijahhezekiah.animeapp.domain.use_case

import android.util.Log
import com.elijahhezekiah.animeapp.common.Resource
import com.elijahhezekiah.animeapp.data.dto.TrendingAnimeListDto
import com.elijahhezekiah.animeapp.data.repository.KitsuRepositoryImpl
import com.elijahhezekiah.animeapp.domain.model.AnimeData
import com.elijahhezekiah.animeapp.domain.repository.KitsuRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTrendingAnimeUseCase @Inject constructor(
    private val repository: KitsuRepository
){
    operator fun invoke(): Flow<Resource<List<AnimeData>>> = flow {
       try {
           emit(Resource.Loading())

           val anime = repository.getTrendingAnime()?.toModel()

           emit(Resource.Success(anime))

           Log.d("This are the Anime", "$anime")

       }  catch(e: HttpException) {
           emit(Resource.Error<List<AnimeData>>(e.localizedMessage ?: "An unexpected error occured"))
       } catch(e: IOException) {
           emit(Resource.Error<List<AnimeData>>("Couldn't reach server. Check your internet connection."))
       }

    }

}