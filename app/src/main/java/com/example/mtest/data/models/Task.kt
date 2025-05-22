package com.example.mtest.data.models
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    val userId:Int?,
    @PrimaryKey
    val id:Int?,
    val title:String?,
    val completed:Boolean
)
