package com.example.assignment16.room

import androidx.lifecycle.LiveData

class Repository (private val localDao:ItemsDao){
    val readAllData: LiveData<List<ItemsEntity>> = localDao.readData()
    suspend fun addListItem(items:ItemsEntity){
        localDao.addItem(items)
    }

}