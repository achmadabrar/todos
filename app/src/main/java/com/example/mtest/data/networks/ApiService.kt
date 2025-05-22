package com.example.mtest.data.networks

import com.example.mtest.data.models.TaskResponse
import retrofit2.http.GET

interface ApiService {
    @GET("todos")
    suspend fun  getTasks(): TaskResponse
}