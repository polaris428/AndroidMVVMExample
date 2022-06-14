package com.example.androidmvvmexample.writing.recyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmvvmexample.databinding.ItemWriteListBinding


class WritingListAdapter() : RecyclerView.Adapter<WritingListAdapter.ViewHolder>() {
    var listData = mutableListOf<WritingData>()


    fun setData(data:MutableList<WritingData>){
        listData = data
    }

    class ViewHolder(val binding: ItemWriteListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(writingData: WritingData) {
            binding.itemData = writingData
            binding.root.setOnClickListener {
                Log.d("클릭","??????????")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWriteListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size

    }




}