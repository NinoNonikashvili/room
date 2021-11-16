package com.example.assignment16.fragments

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.assignment16.DisplayViewModel
import com.example.assignment16.databinding.FragmentAddItemBinding
import com.example.assignment16.extensions.checkIfEmpty
import com.example.assignment16.extensions.checkLength
import com.example.assignment16.room.ItemsEntity


class AddItem : BaseFragment<FragmentAddItemBinding>(FragmentAddItemBinding::inflate) {
    private lateinit var myViewModel: DisplayViewModel

    override fun start() {
        myViewModel = ViewModelProvider(this).get(DisplayViewModel::class.java)


        binding.BTNSave.setOnClickListener{
            validateData()

        }
    }
    fun validateData(){

        binding.TILDescription.checkLength(32, 300)
        binding.TILTitle.checkLength(5, 30)
        binding.TILImage.checkIfEmpty()
        val title = binding.ETTitle.text
        val description = binding.ETDescription.text
        val image = binding.ETImage.text

        if(!title.isNullOrEmpty()&&
            !description.isNullOrEmpty()&&
            !image.isNullOrEmpty()){
            //typeconvert to store in room
            val ItemData = ItemsEntity(0, "$title","$description")
            myViewModel.addUser(ItemData)
            Toast.makeText(context, "added successfully", Toast.LENGTH_LONG).show()

        }
    }



}

