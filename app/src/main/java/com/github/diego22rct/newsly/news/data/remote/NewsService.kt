package com.github.diego22rct.newsly.news.data.remote

import com.github.diego22rct.appsuperzound.list_album.data.remote.NewsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsService {

    @Headers("Content-Type: application/json")
    @GET("articles.php")
    suspend fun getNews(@Query("description") description: String = "google"): Response<List<NewsDto>>
}