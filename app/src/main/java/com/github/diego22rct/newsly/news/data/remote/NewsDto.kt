package com.github.diego22rct.appsuperzound.list_album.data.remote

import com.github.diego22rct.newsly.news.domain.model.New
import com.github.diego22rct.newsly.news.domain.model.Source

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
fun SourceDto.toSource() = Source(id, name)

fun NewsDto.toNew() = New(
    source.toSource(), author, title, description, url, urlToImage, publishedAt, content
)