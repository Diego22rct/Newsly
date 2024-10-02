package com.github.diego22rct.newsly.news.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewEntity(
    @PrimaryKey
    val idAlbum: String,
    val strAlbum: String,
    val strArtist: String,
    val strAlbumThumb: String,
    val intScore: String
)