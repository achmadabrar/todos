package com.example.mtest.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mtest.data.locals.TaskDatabase
import com.example.mtest.data.models.Task
import com.example.mtest.data.networks.RetroInstance
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {

    private val dao = TaskDatabase.getDatabase(application).taskDao()
    var todos = mutableStateListOf<Task>()
        private set

    var isLoading = mutableStateOf(false)
    var error = mutableStateOf<String?>(null)

    init {
        fetchTasks()
    }

    fun fetchTasks(){
        isLoading.value = true
        error.value = null

        viewModelScope.launch {
            try {
                val response = RetroInstance.api.getTasks()
                dao.insertTask(response.tasks)
                todos.clear()
                todos.addAll(response.tasks)
            } catch (e: Exception) {
                error.value = e.message ?: "Unknown Error"
                val localDb = dao.getLocalTasks()
                todos.clear()
                todos.addAll(localDb)
            } finally {
                isLoading.value = false
            }
        }
    }
}