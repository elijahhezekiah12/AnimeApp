package com.elijahhezekiah.animeapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class DimensionsX(
    val large: Large,
    val medium: Medium,
    val small: Small,
    val tiny: Tiny
)