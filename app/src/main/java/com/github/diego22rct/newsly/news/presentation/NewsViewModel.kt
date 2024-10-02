package com.github.diego22rct.newsly.news.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.diego22rct.appsuperzound.list_album.data.repository.NewsRepository
import com.github.diego22rct.newsly.common.Resource
import com.github.diego22rct.newsly.news.data.local.NewDao
import com.github.diego22rct.newsly.news.data.local.NewEntity
import com.github.diego22rct.newsly.news.domain.model.New
import kotlinx.coroutines.launch
import java.util.UUID

class NewsViewModel(private val newsRepository: NewsRepository, private val newDao: NewDao) : ViewModel() {

    private val _newsList = mutableStateOf<List<New>>(emptyList())
    val newsList: MutableState<List<New>> get() = _newsList

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            Log.d("NewsViewModel", "Fetching news...")
            when (val result = newsRepository.getNews()) {
                is Resource.Success -> {
                    _newsList.value = result.data!!
                    Log.d("NewsViewModel", "Fetched news: ${result.data}")
                }

                is Resource.Error -> {
                    Log.d("NewsViewModel", "Error fetching news: ${result.message}")
                }

                is Resource.Loading -> {
                    Log.d("NewsViewModel", "Loading news...")
                }
            }
        }
    }

    fun toggleFavorite(news: New) {
        news.favorite = !news.favorite
        viewModelScope.launch {
            newsRepository.addFavoriteNew(news)
        }
    }

    suspend fun addFavoriteNew(new: New) {
        val newEntity = NewEntity(
            id = UUID.randomUUID().toString(),
            author = new.author ?: "Unknown author",
            title = new.title,
            description = new.description ?: "",
            urlToImage = new.urlToImage ?: "",
        )
        newDao.insert(newEntity)
    }
}