package com.example.test.data.local.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["id"], unique = true)])
data class ToDoEntity(
    @PrimaryKey val key: Int? = null,
    val id: Int? = null,
    val todo: String,
    val completed: Boolean,
    val userId: Int
)