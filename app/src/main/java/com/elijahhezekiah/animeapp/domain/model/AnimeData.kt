package com.elijahhezekiah.animeapp.domain.model

import com.elijahhezekiah.animeapp.data.dto.Links
import com.elijahhezekiah.animeapp.data.dto.Relationships

data class AnimeData(
    val attributes: Attributes,
    val id: String,
    val links: Links,
    val relationships: Relationships,
    val type: String
)