package com.example.mtest.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mtest.viewmodel.TaskViewModel

@Composable
fun TodoScreen(viewModel: TaskViewModel) {
    val tasks = viewModel.todos
    val error = viewModel.error.value

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Today's Task",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )


    }
}