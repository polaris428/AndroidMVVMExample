package com.example.androidmvvmexample.writing

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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

        myAdapter= WritingListAdapter()
        binding.writeListRecyclerView.adapter = myAdapter
        observerData()

    }

    private fun initViewModel() {
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        binding.mainViewModel=mainViewModel

    }

    @SuppressLint("NotifyDataSetChanged")
    fun observerData(){
        mainViewModel.fetchData().observe(this, Observer {
            myAdapter.setData(it)
            myAdapter.notifyDataSetChanged()
        })
    }

}