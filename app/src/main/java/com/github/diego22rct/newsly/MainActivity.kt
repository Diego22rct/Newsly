package com.github.diego22rct.newsly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.github.diego22rct.appsuperzound.list_album.data.repository.NewsRepository
import com.github.diego22rct.newsly.common.Constants
import com.github.diego22rct.newsly.common.Screens
import com.github.diego22rct.newsly.home.presentation.HomeScreen
import com.github.diego22rct.newsly.news.data.local.AppDatabase
import com.github.diego22rct.newsly.news.data.remote.NewsService
import com.github.diego22rct.newsly.news.presentation.FavoriteNewsScreen
import com.github.diego22rct.newsly.news.presentation.NewsViewModel
import com.github.diego22rct.newsly.news.presentation.SearchNewsScreen
import com.github.diego22rct.newsly.ui.theme.NewslyTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = Room
            .databaseBuilder(applicationContext, AppDatabase::class.java, "albums-db").build().getNews()
        val listAlbumService: NewsService = Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsService::class.java)

        val newsRepository= NewsRepository(listAlbumService, dao)

        val newsViewModel = NewsViewModel(newsRepository, dao)

        enableEdgeToEdge()
        setContent {
            NewslyTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomAppBar(
                            actions = {
                                Row(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .fillMaxWidth()
                                        .size(12.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Box {
                                        IconButton(onClick = { navController.navigate(Screens.findNews.route) }, modifier = Modifier.padding(24.dp)) {
                                            Icon(
                                                Icons.Default.Search,
                                                contentDescription = "Find News"
                                            )
                                        }
                                    }
                                    Box {
                                        IconButton(
                                            onClick = { navController.navigate(Screens.homeScreen.route) },
                                            modifier = Modifier.padding(24.dp)
                                        ) {
                                            Icon(
                                                Icons.Filled.Home,
                                                contentDescription = "Home"
                                            )
                                        }
                                    }
                                    Box {
                                        IconButton(onClick = { navController.navigate(Screens.favoriteNews.route) }, modifier = Modifier.padding(24.dp)) {
                                            Icon(
                                                Icons.Filled.Favorite,
                                                contentDescription = "Favorite News"
                                            )
                                        }
                                    }
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screens.homeScreen.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(route = Screens.homeScreen.route) {
                            HomeScreen()
                        }
                        composable(route = Screens.findNews.route) {
                            SearchNewsScreen(newsViewModel)
                        }
                        composable(route = Screens.favoriteNews.route) {
                            FavoriteNewsScreen()
                        }
                    }
                }
            }
        }
    }
}
