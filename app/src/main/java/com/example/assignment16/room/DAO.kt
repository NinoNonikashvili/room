package com.example.assignment16.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ItemsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(item:ItemsEntity)
    @Query("SELECT * FROM items ORDER BY id ASC")
    fun readData(): LiveData<List<ItemsEntity>>
}