package com.example.androidmvvmexample.writing

import android.app.Application
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application ): AndroidViewModel(application) {
    var context=application
    fun write(view:View){
        Log.d("afdfsadfd","afdsfasf")
        val intent=Intent(context.applicationContext,WriteActivity::class.java)
        context.applicationContext.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))

    }
}