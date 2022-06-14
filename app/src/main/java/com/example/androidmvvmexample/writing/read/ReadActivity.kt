package com.example.androidmvvmexample.writing.read

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidmvvmexample.R
import com.example.androidmvvmexample.databinding.ActivityReadBinding


class ReadActivity : AppCompatActivity() {
    lateinit var binding: ActivityReadBinding
    lateinit var readViewModel:ReadViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_read)
        readViewModel=ViewModelProvider(this).get(ReadViewModel::class.java)
        binding.readViewModel=readViewModel
        val j = intent
        binding.readViewModel!!.title.value=intent.getStringExtra("title")

        binding.readViewModel!!.content.value=intent.getStringExtra("content")

    }
}