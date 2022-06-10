package com.example.androidmvvmexample.acount.signin

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.*

class SignInViewModel(application: Application) : AndroidViewModel(application) {
    val email = MutableLiveData<String>()
    var paw = MutableLiveData<String>()
    private val todoRepository = FirebaseLoginRepository(application)

    fun onLoginButton(view: View) {
        todoRepository.login(email.toString(),paw.toString())
        Log.e("sdflsadhfjsafkdhkdsdsdsd", email.value.toString())

    }



}