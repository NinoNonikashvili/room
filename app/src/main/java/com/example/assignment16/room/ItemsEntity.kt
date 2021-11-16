package com.example.assignment16.room

import android.app.ActivityManager
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Items")
data class ItemsEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String?,
    val description:String?
)