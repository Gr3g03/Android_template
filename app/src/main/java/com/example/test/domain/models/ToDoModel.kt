package com.example.test.domain.models

data class ToDoModel(
    val id: Int,
    val todo: String,
    val completed: Boolean,
    val userId: Int
)
