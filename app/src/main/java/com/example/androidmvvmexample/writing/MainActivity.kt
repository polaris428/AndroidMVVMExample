package com.example.androidmvvmexample.writing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidmvvmexample.R
import com.example.androidmvvmexample.databinding.ActivityMainBinding
import com.example.androidmvvmexample.writing.recyclerView.WritingData
import com.example.androidmvvmexample.writing.recyclerView.WritingListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit  var binding:ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var myAdapter: WritingListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        binding.writeListRecyclerView.adapter= WritingListAdapter()
        myAdapter= WritingListAdapter()
        binding.writeListRecyclerView.adapter = myAdapter
        myAdapter.listData = mutableListOf(
            WritingData("Han","24"),
            WritingData("LL","24")
        )


    }

    private fun initViewModel() {
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        binding!!.mainViewModel=mainViewModel

    }

}