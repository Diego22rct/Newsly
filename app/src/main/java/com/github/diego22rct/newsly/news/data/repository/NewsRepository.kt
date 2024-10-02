package com.github.diego22rct.appsuperzound.list_album.data.repository


import com.github.diego22rct.appsuperzound.list_album.data.remote.toNew
import com.github.diego22rct.newsly.common.Resource
import com.github.diego22rct.newsly.news.data.local.NewDao
import com.github.diego22rct.newsly.news.data.remote.NewsService
import com.github.diego22rct.newsly.news.domain.model.New
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepository(private val service: NewsService, private val newDao: NewDao) {

    suspend fun getNews(): Resource<List<New>> = withContext(Dispatchers.IO) {
        try {
            val response = service.getNews()
            if (response.isSuccessful) {
                response.body()?.let { newsResponse ->
                    val news = newsResponse.map { it.toNew() }
                    return@withContext Resource.Success(data = news)
                }
                return@withContext Resource.Error(response.message())
            }
            return@withContext Resource.Error(response.message())
        } catch (e: Exception) {
            return@withContext Resource.Error(e.message ?: "An error occurred")
        }
    }
}