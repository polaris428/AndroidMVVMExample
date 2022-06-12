package com.example.androidmvvmexample.firebase

import android.app.Application
import android.content.Intent
import com.example.androidmvvmexample.writing.MainActivity
import com.example.androidmvvmexample.writing.WritingData
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class WritingFirebase(var application: Application) {

    fun writing(title: String, content: String) {
        val writingData = WritingData(title, content)
        val database = Firebase.database
        val myRef = database.getReference("writing").push()
        myRef.setValue(writingData).addOnCompleteListener {
            val intent = Intent(application.applicationContext, MainActivity::class.java)
            application.applicationContext.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
        }

    }


}