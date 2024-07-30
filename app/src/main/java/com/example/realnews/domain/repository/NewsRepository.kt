package com.example.realnews.domain.repository

import com.example.realnews.domain.model.Article
import com.example.realnews.util.Resource

interface NewsRepository {

    suspend fun getTopHeadlines(
        category: String
    ): Resource<List<Article>>
}