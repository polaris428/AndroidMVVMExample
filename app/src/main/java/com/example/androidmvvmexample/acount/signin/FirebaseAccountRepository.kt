package com.example.androidmvvmexample.acount.signin

import android.app.Application
import android.content.Context;
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import com.example.androidmvvmexample.writing.MainActivity
import com.google.firebase.auth.FirebaseAuth


class FirebaseAccountRepository(private var application: Application) {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance();
    fun singIn(email: String, password: String)  {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener  {

            if (it.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Toast.makeText(application.applicationContext, "성공", Toast.LENGTH_LONG).show()
                var intent=Intent(application.applicationContext, MainActivity::class.java)
                application.applicationContext.startActivity(intent.addFlags(FLAG_ACTIVITY_NEW_TASK))
            } else {
                Toast.makeText(application.applicationContext, "실패", Toast.LENGTH_LONG).show()
            }
        }

    }

    fun sigUp(email: String, password: String) {
        Log.d(email, password)
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(application.applicationContext, "회원가입 성공", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(application.applicationContext, "회원가입 실패", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(application.applicationContext, "회원가입 실패", Toast.LENGTH_SHORT).show()
            }
    }

    fun setDate(email: String, password: String) {
        val sp: SharedPreferences = application.applicationContext.getSharedPreferences("account", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor=sp.edit()
        editor.putString("email",email)
        editor.putString("password",password)
        editor.apply();
    }

    fun getDate(): AccountDate {
        var accountDate:AccountDate
        val sp: SharedPreferences = application.applicationContext.getSharedPreferences("account", Context.MODE_PRIVATE)
        accountDate= AccountDate(sp.getString("email","").toString(),sp.getString("password","").toString())
        return accountDate

    }



}