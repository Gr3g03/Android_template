package com.example.test.data.local

import androidx.room.*
import com.example.test.data.local.entities.ToDoEntity

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(entity: ToDoEntity): Long

    @Query("SELECT * FROM ToDoEntity")
    suspend fun read(): List<ToDoEntity>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(entity: ToDoEntity)

    @Query("DELETE FROM ToDoEntity")
    suspend fun delete()

    @Transaction
    suspend fun upsert(entity: ToDoEntity) {
        val id = create(entity)
        if (id == -1L) {
            update(entity)
        }
    }
}