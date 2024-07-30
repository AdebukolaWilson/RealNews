package com.example.realnews.data.repository

import com.example.realnews.data.remote.NewsApi
import com.example.realnews.domain.model.Article
import com.example.realnews.domain.repository.NewsRepository
import com.example.realnews.util.Resource

class NewsRepositoryImpl(
    private val newsApi: NewsApi
): NewsRepository {
    override suspend fun getTopHeadlines(category: String): Resource<List<Article>> {
        return try {
            val response = newsApi.getBreakingNews(category = category)
            Resource.Success(response.articles)
        }catch (e: Exception) {
            Resource.Error(message = "Failed to fetch news ${e.message}")
        }
    }
}