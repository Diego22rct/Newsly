package com.github.diego22rct.newsly.news.domain.model

data class New(
    val author: String,
    val title: String,
    val description: String,
    val publishedAt: String,
    val urlToImage : String,
    var favorite: Boolean = false
)