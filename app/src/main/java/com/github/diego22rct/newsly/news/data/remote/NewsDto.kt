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
    author ?: source.name,
    title,
    description ?: "",
    publishedAt,
    urlToImage ?: ""
)