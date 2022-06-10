package com.example.androidmvvmexample.acount.signin

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.*

class SignInViewModel(application: Application) : AndroidViewModel(application) {
    val email = MutableLiveData<String>()
    var paw = MutableLiveData<String>()
    private val firebaseRepository = FirebaseAccountRepository(application)

    fun onLoginButton(view: View) {
        firebaseRepository.login(email.toString(),paw.toString())
        Log.e("이메일", email.value.toString())

    }
    fun onCreateUser(view: View){
        firebaseRepository.createUser(email.value.toString(),paw.value.toString())
    }



}