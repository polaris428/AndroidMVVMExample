package com.example.androidmvvmexample.writing

import android.app.Application
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidmvvmexample.firebase.WritingFirebase
import com.example.androidmvvmexample.writing.recyclerView.WritingData
import com.example.androidmvvmexample.writing.recyclerView.WritingListAdapter

class MainViewModel(application: Application ): AndroidViewModel(application) {
    var context=application
    var title=MutableLiveData<String>()
    var content=MutableLiveData<String>()
    private val repo = WritingFirebase(application)
    fun fetchData(): LiveData<MutableList<WritingData>> {
        val mutableData = MutableLiveData<MutableList<WritingData>>()
        repo.getData().observeForever{
            mutableData.value = it
        }
        return mutableData
    }
    fun write(view:View){
        Log.d("afdfsadfd","afdsfasf")
        val intent=Intent(context.applicationContext,WriteActivity::class.java)
        context.applicationContext.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))

    }


    fun writing(view:View){
        repo.writing(title.value.toString(),content.value.toString())
        getWriting()
    }
    fun getWriting(){
        repo.getWriteDate()
    }

}