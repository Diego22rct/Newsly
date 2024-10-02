package com.github.diego22rct.newsly.news.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(newEntity: NewEntity)

    @Query("SELECT * FROM news")
    suspend fun fetchAll(): List<NewEntity>
}