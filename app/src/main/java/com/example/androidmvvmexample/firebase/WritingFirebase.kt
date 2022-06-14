package com.example.androidmvvmexample.firebase

import android.app.Application
import android.content.Intent
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidmvvmexample.writing.MainActivity
import com.example.androidmvvmexample.writing.recyclerView.WritingData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class WritingFirebase(var application: Application) {
    private val database = Firebase.database
    private val myRef = database.getReference("writing")
    fun writing(title: String, content: String) {
        val writingData = WritingData(title, content)

        myRef.push().setValue(writingData).addOnCompleteListener {
            val intent = Intent(application.applicationContext, MainActivity::class.java)
            application.applicationContext.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
        }

    }
    fun getWriteDate(){
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val writingData = dataSnapshot.getValue(WritingData::class.java)
                Log.d(writingData!!.title,"dsdsds")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })


    }

        fun getData(): LiveData<MutableList<WritingData>> {
            val mutableData = MutableLiveData<MutableList<WritingData>>()
            myRef.addValueEventListener(object : ValueEventListener {
                val listData: MutableList<WritingData> = mutableListOf<WritingData>()
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()){
                        for (userSnapshot in snapshot.children){
                            val getData = userSnapshot.getValue(WritingData::class.java)
                            listData.add(getData!!)

                            mutableData.value = listData
                        }
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
            return mutableData

    }


}