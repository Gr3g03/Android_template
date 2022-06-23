package com.example.test.data.remote.dto

data class ToDoPostDto(
    val id: Int? = null,
    val todo: String,
    val completed: Boolean = false,
    val userId: Int
)
