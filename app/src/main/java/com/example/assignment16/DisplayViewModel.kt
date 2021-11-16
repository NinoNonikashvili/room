package com.example.assignment16

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.assignment16.room.ItemsDatabase
import com.example.assignment16.room.ItemsEntity
import com.example.assignment16.room.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DisplayViewModel(application: Application): AndroidViewModel(application) {
    val readData: LiveData<List<ItemsEntity>>
    private val repository: Repository
    init {
        val listDao = ItemsDatabase.getDatabase(application).itemsDao()
        repository = Repository(listDao)
        readData = repository.readAllData
    }

    fun addUser(item:ItemsEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.addListItem(item)
        }
    }



}
