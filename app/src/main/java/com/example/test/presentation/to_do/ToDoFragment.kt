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
import com.example.test.presentation.to_do.recycler_view.ToDoRecycleViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ToDoFragment : Fragment() {

    private val viewModel: ToDoViewModel by viewModels()

    private val adapter = ToDoRecycleViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_to_do, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycle_to_do)

        val fab: FloatingActionButton = view.findViewById(R.id.addBtn)

        fab.setOnClickListener {
                findNavController().navigate(R.id.navigation_add_to_do)
        }

        recyclerView.apply {

            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    (this.layoutManager as LinearLayoutManager).orientation
                )
            )

            adapter = this@ToDoFragment.adapter
            setHasFixedSize(true)
        }

        return view
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