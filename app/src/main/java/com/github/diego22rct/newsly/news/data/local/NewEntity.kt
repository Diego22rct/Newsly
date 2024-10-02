package com.github.diego22rct.newsly.news.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewEntity(
    @PrimaryKey
    val id: String,
    val author: String,
    val title: String,
    val description: String,
    val urlToImage : String,
)