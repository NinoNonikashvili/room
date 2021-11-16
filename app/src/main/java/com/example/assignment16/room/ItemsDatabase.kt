package com.example.assignment16.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ItemsEntity::class], version = 1)
abstract class ItemsDatabase : RoomDatabase() {
    abstract fun itemsDao(): ItemsDao
    companion object {
        private var INSTANCE: ItemsDatabase?=null

        fun getDatabase(context: Context):ItemsDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemsDatabase::class.java,
                    "items_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}