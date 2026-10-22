package com.pes.todoapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoItem(
    @PrimaryKey (autoGenerate = true)
    val id: Int,

    val title: String,
    var priority: String,
    var tobeReminded: Boolean
    )