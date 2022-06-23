package com.example.test.presentation.to_do

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.test.data.remote.dto.ToDoPostDto
import com.example.test.databinding.FragmentAddToDoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddToDoFragment : DialogFragment() {
    private var _binding: FragmentAddToDoBinding? = null
    val binding: FragmentAddToDoBinding get() = _binding!!

    private val viewModel: ToDoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAddToDoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnAddItem.setOnClickListener {
            val model = ToDoPostDto(
                todo = binding.etNewItem.text.toString(),
                userId = 1
            )

            viewModel.addToDo(model)
        }
    }
}