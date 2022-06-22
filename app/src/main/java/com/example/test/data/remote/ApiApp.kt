package com.example.test.data.remote

import com.example.test.data.remote.dto.ToDoPostDto
import com.example.test.data.remote.dto.ToDoResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiApp {
    @GET("/todos/")
    suspend fun getData(): ToDoResponseDto

    @POST("post")
    suspend fun createData(@Body post: ToDoPostDto)
}