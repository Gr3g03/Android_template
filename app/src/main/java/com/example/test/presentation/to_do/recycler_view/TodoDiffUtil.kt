package com.example.test.presentation.to_do.recycler_view

import androidx.recyclerview.widget.DiffUtil
import com.example.test.domain.models.ToDoModel

class TodoDiffUtil: DiffUtil.ItemCallback<ToDoModel>() {
    override fun areItemsTheSame(oldItem: ToDoModel, newItem: ToDoModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ToDoModel, newItem: ToDoModel): Boolean {
        return oldItem == newItem
    }
}