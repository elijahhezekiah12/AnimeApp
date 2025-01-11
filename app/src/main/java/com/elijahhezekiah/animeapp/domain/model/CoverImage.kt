package com.elijahhezekiah.animeapp.domain.model

import com.elijahhezekiah.animeapp.data.dto.Meta
import kotlinx.serialization.Serializable

@Serializable
data class CoverImage(
    val large: String,
    val original: String,
    val small: String,
    val tiny: String
)