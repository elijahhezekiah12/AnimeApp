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
    val relationships: Relationships,
    val type: String
){
    fun toModel(): AnimeData =
        AnimeData(
            id = id,
            attributes = attributes.toModel(),
            links = links,
            relationships = relationships,
            type = type
        )
}



data class AttributesDto(
    val abbreviatedTitles: List<String>,
    val ageRating: String,
    val ageRatingGuide: String,
    val averageRating: String,
    val canonicalTitle: String,
    val coverImage: CoverImageDto,
    val coverImageTopOffset: Int,
    val createdAt: String,
    val description: String,
    val endDate: String,
    val episodeCount: Int,
    val episodeLength: Int,
    val favoritesCount: Int,
    val nextRelease: String,
    val nsfw: Boolean,
    val popularityRank: Int,
    val posterImage: PosterImageDto,
    val ratingFrequencies: RatingFrequencies,
    val ratingRank: Int,
    val showType: String,
    val slug: String,
    val startDate: String,
    val status: String,
    val subtype: String,
    val synopsis: String,
    val tba: String,
    val titles: TitlesDto,
    val totalLength: Int,
    val updatedAt: String,
    val userCount: Int,
    val youtubeVideoId: String
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
            coverImageTopOffset = coverImageTopOffset,
            description = description,
            nextRelease = nextRelease,
            nsfw = nsfw,
            ratingFrequencies = ratingFrequencies,
            tba = tba,
            totalLength = totalLength,
            youtubeVideoId = youtubeVideoId
        )
}


data class TitlesDto(
    val en: String,
    val en_jp: String,
    val en_us: String,
    val ja_jp: String
) {
    fun toModel(): Titles =
        Titles(
            en = en,
            en_jp = en_jp,
            en_us = en_us,
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
            meta = meta.toModel()
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
