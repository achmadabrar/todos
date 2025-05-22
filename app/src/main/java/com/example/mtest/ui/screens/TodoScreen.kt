package com.example.mtest.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mtest.viewmodel.TaskViewModel

@Composable
fun TodoScreen(viewModel: TaskViewModel) {
    val tasks = viewModel.todos
    val error = viewModel.error.value

    var hardCoderow = 7

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Today's Task",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow (
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(hardCoderow) { index ->
                Card(
                    modifier = Modifier.size(width = 70.dp, height = 80.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                ) {
                 Column(
                     modifier = Modifier.fillMaxSize(),
                     verticalArrangement = Arrangement.Center,
                     horizontalAlignment = Alignment.CenterHorizontally
                 ) {
                     Text(text = "Bulan")
                     Text(text = "${20 + index}", style = MaterialTheme.typography.titleLarge)
                 }   
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val categories = listOf("All, To Do", "In Progress", "Completed")
            items(categories) { category ->
                AssistChip(onClick = { /*TODO*/ }, label = { Text(text = category) })
            }
        }

        error?.let {
            Text(text = it, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(horizontal = 16.dp))
        }

        //List
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(tasks) { task ->
                Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
                    Row {
                        task.title?.let { Text(text = it, modifier = Modifier.weight(1f)) }
                        task.completed?.let { 
                           if (task.completed) {
                               Text(text = "Done")
                           } else {
                               Text(text = "In Progress")
                           }
                        }
                    }
                }
            }
        }
    }
}