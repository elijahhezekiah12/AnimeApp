package com.elijahhezekiah.animeapp.data.dto

import com.elijahhezekiah.animeapp.domain.model.AnimeData
import com.elijahhezekiah.animeapp.domain.model.Attributes
import com.elijahhezekiah.animeapp.domain.model.CoverImage
import com.elijahhezekiah.animeapp.domain.model.PosterImage
import com.elijahhezekiah.animeapp.domain.model.Titles

data class TrendingAnimeListDto(
    val data : List<AnimeDataDto>
){
    fun toModel(): List<AnimeData> = data.map {
        it.toModel()

    }
}


data class AnimeResponseDto(
    val data: AnimeDataDto
) {
    fun toModel(): AnimeData = data.toModel()
}


data class AnimeDataDto(
    val attributes: AttributesDto,
    val id: String,
    val links: Links,
    val relationships: RelationshipsDto,
    val type: String
){
    fun toModel(): AnimeData =
        AnimeData(
            id = id,
            attributes = attributes.toModel()
        )
}



data class AttributesDto(
    val createdAt: String,
    val updatedAt: String,
    val slug: String?,
    val synopsis: String?,
    val coverImageTopOffset: Int,
    val titles: TitlesDto,
    val canonicalTitle: String?,
    val abbreviatedTitles: List<String>,
    val averageRating: String?,
    val ratingFrequencies: Map<String,String>,
    val userCount: Int?,
    val favoritesCount: Int?,
    val startDate: String?,
    val endDate: String?,
    val popularityRank: Int?,
    val ratingRank: Int?,
    val ageRating: String?,
    val ageRatingGuide: String?,
    val subtype: String,
    val status: String,
    val tba: String?,
    val posterImage: PosterImageDto,
    val coverImage: CoverImageDto,
    val episodeCount: Int?,
    val episodeLength: Int?,
    val youtubeVideoId: String?,
    val showType: String?,
    val nsfw: Boolean
) {
    fun toModel(): Attributes =  Attributes(
            createdAt = createdAt,
            updatedAt = updatedAt,
            slug = slug,
            synopsis = synopsis,
            titles = titles.toModel(),
            canonicalTitle = canonicalTitle,
            abbreviatedTitles = abbreviatedTitles,
            ageRating = ageRatingGuide,
            coverImage = coverImage.toModel(),
            subtype = subtype,
            posterImage = posterImage.toModel(),
            episodeCount = episodeCount,
            episodeLength = episodeLength,
            showType = showType,
            ageRatingGuide = ageRatingGuide,
            favoritesCount = favoritesCount,
              popularityRank = popularityRank,
            status = status,
            endDate = endDate,
            startDate = startDate,
            userCount = userCount,
            averageRating = averageRating,
            ratingRank = ratingRank,
        )
}


data class TitlesDto(
    val en: String?,
    val en_jp: String?,
    val ja_jp: String?
) {
    fun toModel(): Titles =
        Titles(
            en = en,
            en_jp = en_jp,
            ja_jp = ja_jp
        )
}


data class CoverImageDto(
    val tiny: String,
    val small: String,
    val large: String,
    val original: String,
    val meta: MetaDto
) {
    fun toModel(): CoverImage =
        CoverImage(
            tiny = tiny,
            small = small,
            large = large,
            original = original,
        )
}

data class MetaDto(
    val dimensions: DimensionsDto
){
    fun toModel(): Meta =
        Meta(
            dimensions = dimensions.toModel()
        )
}

data class DimensionsDto(
    val tiny: SizeDto,
    val small: SizeDto,
    val large: SizeDto
){
    fun toModel(): Dimensions =
        Dimensions(
            tiny = tiny.toModelTiny(),
            small = small.toModelSmall(),
            large = large.toModelLarge()
        )
}

data class SizeDto(
    val width: Int ,
    val height: Int
){
    fun toModelTiny(): Tiny =
        Tiny(
            width = width,
            height = height
        )

    fun toModelSmall(): Small =
        Small(
            width = width,
            height = height
        )

    fun toModelLarge(): Large =
        Large(
            width = width,
            height = height
        )

}

data class PosterImageDto(
    val tiny: String,
    val small: String,
    val medium: String,
    val large: String,
    val original: String,
    val meta: MetaX
) {
    fun toModel(): PosterImage =
        PosterImage(
            tiny = tiny,
            small = small,
            medium = medium,
            large = large,
            original = original,
            meta = meta
        )
}


data class RelationshipsDto(
    val genres: RelationDto,
    val categories: RelationDto,
    val castings: RelationDto,
    val installments: RelationDto,
    val mappings: RelationDto,
    val reviews: RelationDto,
    val mediaRelationships: RelationDto,
    val episodes: RelationDto,
    val streamingLinks: RelationDto,
    val animeProductions: RelationDto,
    val animeCharacters: RelationDto,
    val animeStaff: RelationDto
)

data class RelationDto(
    val links: RelationLinksDto
)

data class RelationLinksDto(
    val self: String,
    val related: String
)