package com.github.diego22rct.newsly.news.domain.model

data class New(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?,
    var favorite: Boolean = false
)

data class Source(
    val id: String?,
    val name: String
)
