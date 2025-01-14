package com.elijahhezekiah.animeapp.domain.model

import com.elijahhezekiah.animeapp.data.dto.MetaX
import kotlinx.serialization.Serializable

@Serializable
data class PosterImage(
    val large: String,
    val medium: String,
    val meta: MetaX,
    val original: String,
    val small: String,
    val tiny: String
)