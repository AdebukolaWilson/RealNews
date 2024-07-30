package com.example.realnews.data.remote

import com.example.realnews.domain.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    //    https://newsapi.org/v2/top-headlines?country=us&apiKey=2386f3ce033b4bbbb54d348d201eaade

    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("category") category: String,
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse


    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
        const val API_KEY = "2386f3ce033b4bbbb54d348d201eaade"
    }
}