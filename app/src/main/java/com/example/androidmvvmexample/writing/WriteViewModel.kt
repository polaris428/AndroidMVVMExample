package com.example.androidmvvmexample.writing

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidmvvmexample.firebase.WritingFirebase

class WriteViewModel(application: Application): AndroidViewModel(application) {
    var writingFirebase=WritingFirebase(application)
    var title=MutableLiveData<String>()
    var content=MutableLiveData<String>()

    fun writing(view:View){
        writingFirebase.writing(title.value.toString(),content.value.toString())
    }
}