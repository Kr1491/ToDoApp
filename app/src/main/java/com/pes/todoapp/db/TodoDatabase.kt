package com.pes.todoapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoItem::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun getDao() : TodoDAO

    // singleton pattern
    companion object {
        private var instance : TodoDatabase? = null

        fun getInstance(ctx: Context) : TodoDatabase? {

            if(instance == null) {
                // first time
                instance = buildDatabase(ctx.applicationContext)
            }

            return instance
        }

        private fun buildDatabase(context: Context): TodoDatabase {

           return Room.databaseBuilder(context,
                TodoDatabase::class.java,
                "Todo.db")
               .build()
        }
    }


}