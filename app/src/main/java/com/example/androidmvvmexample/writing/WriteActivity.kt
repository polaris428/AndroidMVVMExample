package com.example.androidmvvmexample.writing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidmvvmexample.R
import com.example.androidmvvmexample.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {
    private var binding:ActivityWriteBinding?=null
    private lateinit  var mainViewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }
    fun  init(){
      
        binding= DataBindingUtil.setContentView(this,R.layout.activity_write)
        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        binding!!.mainViewModel=mainViewModel
    }
}