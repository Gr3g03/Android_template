package com.example.test.domain.repository

import com.example.test.data.remote.dto.ToDoPostDto
import com.example.test.domain.models.ToDoModel
import com.example.test.util.Resource
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    fun getData():Flow<Resource<List<ToDoModel>>>
    fun createData():Flow<Resource<List<ToDoPostDto>>>
}