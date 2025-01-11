package com.elijahhezekiah.animeapp.presentation.trending_anime.components

import android.graphics.drawable.Icon
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.elijahhezekiah.animeapp.domain.model.AnimeData


@OptIn(ExperimentalSharedTransitionApi::class)

@Composable
fun SharedTransitionScope.AnimeCard(
    anime: AnimeData,
    onClick: () -> Unit,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier
 ){

    Card(
        modifier = modifier,
        onClick = onClick
    ){

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(6.dp)
        ){

            AsyncImage(
                model = anime.attributes.posterImage.original,
                contentDescription = "anime image",
                modifier = Modifier
                    .size(96.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .sharedElement(
                        rememberSharedContentState(key = anime.id),
                        animatedVisibilityScope = animatedVisibilityScope
                    ),
                contentScale = ContentScale.Crop
            )

            Column {
                 Row(
                     modifier = Modifier.background(
                         Color(0xFFC4C7EB),
                         shape = RoundedCornerShape(20.dp)
                     )
                         .padding(horizontal = 8.dp, vertical = 4.dp)
                 ){

                     Icon(
                         imageVector = Icons.Rounded.Star,
                         contentDescription = "rating",
                         tint = Color.Yellow
                     )
                     Text(text = anime.attributes.averageRating?:"")

                 }

                Text(
                    text = anime.attributes.canonicalTitle?:"",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = anime.attributes.synopsis?:"",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )


            }


        }

    }


 }