package com.example.test.presentation.to_do

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.data.remote.dto.ToDoPostDto
import com.example.test.domain.models.ToDoModel
import com.example.test.domain.repository.ToDoRepository
import com.example.test.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel() {
    private val _event = MutableStateFlow<List<ToDoModel>>(emptyList())
    val event: StateFlow<List<ToDoModel>> = _event

    init {
        getData()
    }

    private fun getData() {
        viewModelScope
            .launch {
                repository.getData()
                    .collect { resource ->
                        when (resource) {
                            is Resource.Error -> Unit
                            is Resource.Loading -> Unit
                            is Resource.Success -> {
                                resource.data?.let {
                                    _event.value = it
                                }
                            }
                        }
                    }
            }
    }

    fun addToDo(model: ToDoPostDto) {
        viewModelScope.launch {
            repository
                .createData(model)
                .collect { resource ->
                    when (resource) {
                        is Resource.Error -> Unit
                        is Resource.Loading -> Unit
                        is Resource.Success -> Unit
                    }
                }
        }
    }
}