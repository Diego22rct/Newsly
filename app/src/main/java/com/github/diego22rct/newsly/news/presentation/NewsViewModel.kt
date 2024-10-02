package com.github.diego22rct.newsly.news.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.diego22rct.appsuperzound.list_album.data.repository.NewsRepository
import com.github.diego22rct.newsly.common.Resource
import com.github.diego22rct.newsly.news.domain.model.New
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val _newsList = MutableLiveData<Resource<List<New>>>()
    val newsList: LiveData<Resource<List<New>>> get() = _newsList

    init {
        fetchNews()
    }

    fun fetchNews() {
        viewModelScope.launch {
            val result = newsRepository.getNews()
            _newsList.value = result
        }
    }
}