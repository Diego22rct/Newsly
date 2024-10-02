package com.github.diego22rct.newsly.news.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.github.diego22rct.newsly.news.domain.model.New
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun SearchNewsScreen(newsViewModel: NewsViewModel) {
    val newsList = newsViewModel.newsList.value

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Search News", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(16.dp))
            LazyColumn {
                items(newsList) { news ->
                    NewsItem(news)
                }
            }
        }
    }
}

@Composable
fun NewsItem(news: New) {
    Column(modifier = Modifier.padding(16.dp)) {
        Card(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(news.author, style = MaterialTheme.typography.bodyMedium)
                val year = news.publishedAt.substring(0, 4)
                Text(year, style = MaterialTheme.typography.bodySmall)
                GlideImage(
                    modifier = Modifier.fillMaxWidth().size(200.dp),
                    imageModel = { news.urlToImage },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )
                )
            }
        }
    }
}