package com.example.test.presentation.to_do.recycler_view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.domain.models.ToDoModel

class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: TextView = itemView.findViewById(R.id.txt_title)
    val completed: TextView = itemView.findViewById(R.id.txt_completed)

    fun bind(model: ToDoModel) {
        title.text = model.todo
        completed.text = model.completed.toString()
    }
}