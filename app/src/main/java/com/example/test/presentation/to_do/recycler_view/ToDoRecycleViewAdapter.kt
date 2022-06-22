package com.example.test.presentation.to_do.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.domain.models.ToDoModel

class ToDoRecycleViewAdapter :
    ListAdapter<ToDoModel, ToDoRecycleViewAdapter.ToDoViewHolder>(TodoDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_todo_item, parent, false)

        return ToDoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val model = currentList[position]
        holder.bind(model)
    }

    class TodoDiffUtil : DiffUtil.ItemCallback<ToDoModel>() {
        override fun areItemsTheSame(oldItem: ToDoModel, newItem: ToDoModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ToDoModel, newItem: ToDoModel): Boolean {
            return oldItem == newItem
        }
    }

    inner class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.findViewById(R.id.txt_title)
        private val completed: TextView = itemView.findViewById(R.id.txt_completed)

        fun bind(model: ToDoModel) {
            title.text = model.todo
            completed.text = model.completed.toString()
        }
    }
}