package com.example.androidmvvmexample.writing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidmvvmexample.R
import com.example.androidmvvmexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  var binding:ActivityMainBinding?=null
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()

    }

    private fun initViewModel() {
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        binding!!.mainViewModel=mainViewModel

    }

}