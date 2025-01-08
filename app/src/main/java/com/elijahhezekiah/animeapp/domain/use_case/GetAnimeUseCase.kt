package com.elijahhezekiah.animeapp.domain.use_case

import com.elijahhezekiah.animeapp.common.Resource
import com.elijahhezekiah.animeapp.domain.model.AnimeData
import com.elijahhezekiah.animeapp.domain.repository.KitsuRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAnimeUseCase @Inject constructor(
    private val repository: KitsuRepository
) {
    operator fun invoke(animeID: Int): Flow<Resource<AnimeData>> = flow {
        try {
            emit(Resource.Loading<AnimeData>())
            val anime = repository.getAnimeById(animeID)
            emit(Resource.Success<AnimeData>(anime.toModel()))

        }  catch(e: HttpException) {
            emit(Resource.Error<AnimeData>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<AnimeData>("Couldn't reach server. Check your internet connection."))
        }
    }

}