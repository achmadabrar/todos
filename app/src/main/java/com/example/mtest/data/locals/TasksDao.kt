package com.example.mtest.data.locals

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mtest.data.models.Task

@Dao
interface TasksDao {
    @Query("SELECT * FROM tasks")
    suspend fun getLocalTasks(): List<Task>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(tasks: List<Task>)
}