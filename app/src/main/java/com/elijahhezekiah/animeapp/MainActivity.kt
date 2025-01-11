package com.elijahhezekiah.animeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.elijahhezekiah.animeapp.presentation.anime.AnimeScreen
import com.elijahhezekiah.animeapp.presentation.trending_anime.TrendingAnimeScreen
import com.elijahhezekiah.animeapp.ui.theme.AnimeAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalSharedTransitionApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeAppTheme {
               val controller = rememberNavController()

                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.dark(
                        android.graphics.Color.TRANSPARENT
                    )
                )
              SharedTransitionLayout  {
                   NavHost(
                       navController = controller,
                       startDestination = TrendingAnimeRoute,
                       modifier = Modifier.fillMaxSize()
                   ) {
                       composable<TrendingAnimeRoute> {
                           TrendingAnimeScreen(
                               onAnimeClick = { coverUrl, id ->
                                   controller.navigate(AnimeRoute(coverUrl, id))
                               },
                               animatedVisibilityScope = this@composable
                           )
                       }

                       composable<AnimeRoute> {
                           val args = it.toRoute<AnimeRoute>()

                           AnimeScreen(
                               animatedVisibilityScope = this@composable ,
                               coverImage = args.coverUrl
                           )
                       }
                   }




                       }

                   }
               }
            }
        }




@Serializable
data object TrendingAnimeRoute

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimeAppTheme {
        Greeting("Android")
    }
}