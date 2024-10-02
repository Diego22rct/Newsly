package com.github.diego22rct.newsly.news.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.diego22rct.newsly.news.domain.model.New

@Entity(tableName = "news")
data class NewEntity(
    @PrimaryKey
    val id: String,
    val author: String,
    val title: String,
    val description: String,
    val publishedAt: String,
    val urlToImage : String,
)

fun NewEntity.toNew() = New(
    author, title, description, publishedAt ,urlToImage, true
)