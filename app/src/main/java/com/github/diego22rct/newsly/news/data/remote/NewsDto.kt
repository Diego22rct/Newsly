package com.github.diego22rct.appsuperzound.list_album.data.remote

import com.github.diego22rct.newsly.news.domain.model.New

data class NewsDto(
    val source: SourceDto,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
)

data class SourceDto(
    val id: String?,
    val name: String
)

fun NewsDto.toNew() = New(
    publishedAt, author ?: "", urlToImage ?: "https://www.wolflair.com/wp-content/uploads/2017/01/placeholder.jpg"
)