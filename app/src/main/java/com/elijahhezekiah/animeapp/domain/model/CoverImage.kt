package com.elijahhezekiah.animeapp.domain.model

import com.elijahhezekiah.animeapp.data.dto.Meta

data class CoverImage(
    val large: String,
    val meta: Meta,
    val original: String,
    val small: String,
    val tiny: String
)