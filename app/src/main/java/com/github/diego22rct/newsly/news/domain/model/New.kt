package com.github.diego22rct.newsly.news.domain.model

data class New (
    val publishedAt: String,
    val author: String,
    val urlToImage: String = "https://www.wolflair.com/wp-content/uploads/2017/01/placeholder.jpg",
    )