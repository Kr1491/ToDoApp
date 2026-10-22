package com.pes.todoapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDAO {

    @Insert
    fun addItem(item: TodoItem)

    @Query ("select * from TodoItem")
    fun getItems(): List<TodoItem>

    @Delete
    fun deleteItem(item: TodoItem)
}