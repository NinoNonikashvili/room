package com.example.assignment16.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment16.DisplayAdapter
import com.example.assignment16.DisplayViewModel
import com.example.assignment16.R
import com.example.assignment16.databinding.FragmentDisplayItemsBinding
import com.example.assignment16.model.DisplayItemData
import com.example.assignment16.room.ItemsEntity
import java.util.Observer


class DisplayItems : BaseFragment<FragmentDisplayItemsBinding>(FragmentDisplayItemsBinding::inflate) {
    var items = mutableListOf(
        ItemsEntity(0, "bla", "blabla"),
    )
    private lateinit var myViewModel:DisplayViewModel
    override fun start() {
        myViewModel = ViewModelProvider(this).get(DisplayViewModel::class.java)

        myViewModel.readData.observe(viewLifecycleOwner, {
        Toast.makeText(context, "$it", Toast.LENGTH_LONG).show()
            items.clear()
            items.addAll(it.toMutableList())
        })
        binding.BTNAdd.setOnClickListener{
            findNavController().navigate(R.id.action_displayItems_to_addItem)//how to replace this with better way?
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = binding.recycler
        recycler.adapter = DisplayAdapter(items)
        recycler.layoutManager = LinearLayoutManager(context)
    }
}