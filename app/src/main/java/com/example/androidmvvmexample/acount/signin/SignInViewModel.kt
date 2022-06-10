package com.example.androidmvvmexample.acount.signin

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class SignInViewModel : ViewModel() {
    val email = MutableLiveData<String>()
    var paw = MutableLiveData<String>()


    fun onLoginButton(view: View) {

        Log.e("sdflsadhfjsafkdhkdsdsdsd", email.value.toString())

    }


}