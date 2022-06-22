package com.example.test.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.test.data.local.entities.ToDoEntity

@Database(
    entities = [ToDoEntity::class],
    version = 3
)

abstract class AppDatabase : RoomDatabase() {
    abstract val toDoDao: ToDoDao
}