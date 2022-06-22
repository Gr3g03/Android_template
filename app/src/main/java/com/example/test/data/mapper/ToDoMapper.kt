package com.example.test.data.mapper

import com.example.test.data.local.entities.ToDoEntity
import com.example.test.data.remote.dto.ToDoDto
import com.example.test.domain.models.ToDoModel

fun ToDoDto.toToDoEntity(): ToDoEntity {
    return ToDoEntity(
        id = id,
        todo = todo,
        completed = completed,
        userId = userId
    )
}

fun ToDoEntity.toToDoModel(): ToDoModel {
    return ToDoModel(
        id = id,
        todo = todo,
        completed = completed,
        userId = userId
    )
}