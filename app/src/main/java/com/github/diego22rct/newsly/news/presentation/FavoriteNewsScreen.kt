package com.github.diego22rct.newsly.news.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteNewsScreen(newsViewModel: NewsViewModel) {
    val favoriteNewsList = newsViewModel.favoriteNewsList.value

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Favorite News", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(16.dp))
            LazyColumn {
                items(favoriteNewsList) { news ->
                    NewsItem(news, onFavoriteClick = {
                        newsViewModel.toggleFavorite(it)
                    })
                }
            }
        }
    }
}
