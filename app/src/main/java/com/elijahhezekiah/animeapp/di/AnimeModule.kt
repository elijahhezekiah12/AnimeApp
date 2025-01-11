package com.elijahhezekiah.animeapp.di

import com.elijahhezekiah.animeapp.common.Constants
import com.elijahhezekiah.animeapp.data.KitsuApi
import com.elijahhezekiah.animeapp.data.repository.KitsuRepositoryImpl
import com.elijahhezekiah.animeapp.domain.repository.KitsuRepository
import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AnimeModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Provides
    @Singleton
    fun provideKitsuApi(moshi: Moshi): KitsuApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(KitsuApi::class.java)
    }


    @Singleton
    @Provides
    fun provideKitsuRepository(api: KitsuApi): KitsuRepository =
        KitsuRepositoryImpl(api = api)


}