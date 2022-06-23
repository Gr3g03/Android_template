package com.example.test.domain.models

data class ToDoModel(
    val id: Int? = null,
    val todo: String,
    val completed: Boolean = false,
    val userId: Int
)
