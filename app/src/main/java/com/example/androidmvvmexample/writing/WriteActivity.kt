package com.example.androidmvvmexample.writing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidmvvmexample.R
import com.example.androidmvvmexample.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {
    private var binding:ActivityWriteBinding?=null
    private lateinit  var writeViewModel:WriteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }
    fun  init(){
        binding=DataBindingUtil.setContentView(this,R.layout.activity_write)
        writeViewModel=ViewModelProvider(this).get(WriteViewModel::class.java)
        binding!!.writeModel=writeViewModel
    }
}