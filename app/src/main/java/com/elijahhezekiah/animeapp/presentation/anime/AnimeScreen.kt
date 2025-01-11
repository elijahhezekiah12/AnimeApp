package com.elijahhezekiah.animeapp.presentation.anime

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.elijahhezekiah.animeapp.domain.model.CoverImage

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.AnimeScreen(
    viewModel: AnimeViewModel = hiltViewModel(),
    coverImage: String,
    animatedVisibilityScope: AnimatedVisibilityScope
){
    val state = viewModel.state.value

    Scaffold { innerPadding ->

     state.anime?.let { anime->

            LazyColumn(
                modifier = Modifier.fillMaxSize()
                    .padding(bottom = innerPadding.calculateBottomPadding()),
                horizontalAlignment = Alignment.Start
            ) {

                item {
                    AsyncImage(
                        model = coverImage,
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                            .height(300.dp)
                            .clip(
                                RoundedCornerShape(
                                    bottomEnd = 20.dp
                                )
                            )
                            .sharedElement(
                                rememberSharedContentState(key = anime.id),
                                animatedVisibilityScope = animatedVisibilityScope
                            ),
                        contentScale = ContentScale.Crop
                    )

                }


          item {
                    Column (
                        modifier = Modifier.padding(10.dp)
                            .padding(horizontal = 10.dp, vertical = 16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = anime.attributes.canonicalTitle?:"",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = anime.attributes.startDate?.split("-")?.first()?:"",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Medium
                            )

                            Text(
                                text = " - ",
                                modifier = Modifier.padding(horizontal = 4.dp)
                            )

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(1.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Star,
                                    contentDescription = null,
                                    modifier = Modifier.padding(end = 4.dp)
                                )

                                Text(
                                    text = anime.attributes.averageRating?:"",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Medium
                                )
                            }

                        }


                        Spacer(modifier = Modifier.height(16.dp))

                        Column(horizontalAlignment = Alignment.Start) {
                            Text(
                                text = "Synopsis",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = anime.attributes.synopsis?:"")

                        }
                    }

                }



            }
        }
        Box(modifier = Modifier.fillMaxSize()) {

                if (state.error.isNotBlank()) {
                    Text(
                        text = state.error,
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                }


                if (state.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }


        }

    }
}