package com.pes.todoapp

data class ToDo (val id: Int,
    var title: String,
    var priority: String,
    var isComplete: Boolean = false,
    var toBeNotified: Boolean = false)