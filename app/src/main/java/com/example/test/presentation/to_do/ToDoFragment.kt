package com.example.test.presentation.to_do

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.FragmentAddToDoBinding
import com.example.test.databinding.FragmentToDoBinding
import com.example.test.presentation.to_do.recycler_view.ToDoRecycleViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ToDoFragment : Fragment() {

    private var _binding: FragmentToDoBinding? = null
    val binding: FragmentToDoBinding get() = _binding!!

    private val viewModel: ToDoViewModel by viewModels()

    private val adapter = ToDoRecycleViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentToDoBinding.inflate(inflater, container, false)



        binding.addBtn.setOnClickListener {
                findNavController().navigate(R.id.navigation_add_to_do)
        }

        binding.recycleToDo.apply {

            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    (this.layoutManager as LinearLayoutManager).orientation
                )
            )

            adapter = this@ToDoFragment.adapter
            setHasFixedSize(true)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        lifecycleScope
            .launch {
                viewModel
                    .event
                    .collect {
                        val data = it

                        if (data.isNotEmpty())
                            adapter.submitList(it)
                    }
            }


    }
}