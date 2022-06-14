package com.example.androidmvvmexample.writing.recyclerView

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmvvmexample.databinding.ItemWriteListBinding
import com.example.androidmvvmexample.writing.MainViewModel
import com.example.androidmvvmexample.writing.read.ReadActivity
import com.example.androidmvvmexample.writing.read.ReadViewModel
import kotlin.math.log


class WritingListAdapter() : RecyclerView.Adapter<WritingListAdapter.ViewHolder>() {
    var listData = mutableListOf<WritingData>()


    fun setData(data: MutableList<WritingData>) {
        listData = data
    }

    class ViewHolder(val binding: ItemWriteListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(writingData: WritingData) {
            binding.itemData = writingData
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, ReadActivity::class.java)

                intent.putExtra("title",writingData.title)
                intent.putExtra("content",writingData.content)
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemWriteListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size

    }


}