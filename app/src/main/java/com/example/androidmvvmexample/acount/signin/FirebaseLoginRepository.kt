package com.example.androidmvvmexample.acount.signin

import android.app.Application
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class FirebaseLoginRepository(private var application: Application) {

    fun login(email:String,password:String) {
        val auth: FirebaseAuth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Toast.makeText(application.applicationContext, "성공", Toast.LENGTH_LONG).show()
            } else {
                // If sign in fails, display a message to the user.
                Toast.makeText(application.applicationContext, "실패", Toast.LENGTH_LONG).show()
            }
        }

    }
}