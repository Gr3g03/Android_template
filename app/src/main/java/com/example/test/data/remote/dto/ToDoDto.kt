package com.example.test.data.remote.dto

data class ToDoDto (
    val id: Int,
    val todo: String,
    val completed: Boolean,
    val userId: Int
)