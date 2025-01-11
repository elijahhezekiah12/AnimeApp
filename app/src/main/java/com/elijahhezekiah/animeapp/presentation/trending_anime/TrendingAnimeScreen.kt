package com.elijahhezekiah.animeapp.presentation.trending_anime

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.elijahhezekiah.animeapp.presentation.trending_anime.components.AnimeCard

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.TrendingAnimeScreen(
    onAnimeClick: (String,String) -> Unit,
    animatedVisibilityScope: AnimatedVisibilityScope,
    viewModel: TrendingAnimeViewModel = hiltViewModel()

){
    val state = viewModel.state.value

    Scaffold {   innerPadding ->
         AnimatedContent(
             targetState = state,
             modifier = Modifier.padding(innerPadding),
             label = ""
         ) { state ->

             if(state.error.isNotBlank()){
                 Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                     CircularProgressIndicator()


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
             }

             else if(state.isLoading){
                 Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                     CircularProgressIndicator()
                 }

             } else{
                 LazyColumn(
                     contentPadding = PaddingValues(
                         top = innerPadding.calculateTopPadding() + 10.dp,
                         start = 20.dp,
                         end = 20.dp,
                         bottom = innerPadding.calculateBottomPadding() + 10.dp,
                     ),
                     verticalArrangement = Arrangement.spacedBy(16.dp)
                 ) {

                     item {
                         Text(
                             text = "Trending Anime",
                             style = MaterialTheme.typography.displayMedium,
                             fontWeight = FontWeight.Bold,
                         )
                     }

                     items(state.trendingAnimeList){ trendingAnime ->
                         AnimeCard(
                             anime = trendingAnime,
                             onClick = {
                                 onAnimeClick(trendingAnime.attributes.posterImage.original, trendingAnime.id)
                                       },
                             animatedVisibilityScope = animatedVisibilityScope
                         )
                     }

                 }

             }


         }
    }
}