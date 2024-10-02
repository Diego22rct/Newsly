package com.github.diego22rct.newsly.news.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(album: NewEntity)

    @Delete
    suspend fun delete(album: NewEntity)

    @Query("SELECT * FROM news")
    suspend fun fetchAll(): List<NewEntity>
}