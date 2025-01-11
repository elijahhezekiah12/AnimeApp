package com.elijahhezekiah.animeapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Titles(
    val en: String?,
    val en_jp: String?,
    val ja_jp: String?
)