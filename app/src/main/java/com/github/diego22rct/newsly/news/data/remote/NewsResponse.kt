package com.github.diego22rct.newsly.news.data.remote

import com.github.diego22rct.appsuperzound.list_album.data.remote.NewsDto

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsDto>
)