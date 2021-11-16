package com.example.assignment16

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment16.databinding.RecyclerItemBinding
import com.example.assignment16.model.DisplayItemData
import com.example.assignment16.room.ItemsEntity

class DisplayAdapter(val Items:List<ItemsEntity>):RecyclerView.Adapter<DisplayAdapter.DisplayViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayViewHolder {
        return DisplayViewHolder(RecyclerItemBinding.inflate(LayoutInflater.from(parent.context),parent, false ))
    }

    override fun onBindViewHolder(holder: DisplayViewHolder, position: Int) {
        holder.description.text = Items[position].title
        holder.title.text = Items[position].description

    }

    override fun getItemCount()=Items.size

    inner class DisplayViewHolder(binding:RecyclerItemBinding):RecyclerView.ViewHolder(binding.root){
        val title = binding.ETTitle
        val description = binding.ETDescription
    }

}