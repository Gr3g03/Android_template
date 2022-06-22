package com.example.test.data.remote.dto

data class ToDoResponseDto(
    val todos: List<ToDoDto>,
    val total: Int,
    val skip: String,
    val limit: Int
)
