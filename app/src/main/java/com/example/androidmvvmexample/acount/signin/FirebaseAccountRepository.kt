package com.example.androidmvvmexample.acount.signin

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class FirebaseAccountRepository(private var application: Application) {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance();
    fun singIn(email:String,password:String) {

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
     fun sigUp(email: String, password: String) {
         Log.d(email,password)
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(application.applicationContext, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser

                } else {

                    Toast.makeText(application.applicationContext, "회원가입 실패", Toast.LENGTH_SHORT).show()

                }
            }
            .addOnFailureListener {
                Toast.makeText(application.applicationContext, "회원가입 실패", Toast.LENGTH_SHORT).show()
            }
    }


}