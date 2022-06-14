package com.example.androidmvvmexample.writing.read

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReadViewModel:ViewModel() {

    var content= MutableLiveData<String>()
    var title= MutableLiveData<String>()


}