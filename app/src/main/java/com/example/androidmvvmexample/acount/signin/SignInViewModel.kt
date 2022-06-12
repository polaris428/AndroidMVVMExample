package com.example.androidmvvmexample.acount.signin

import android.app.Application

import android.util.Log
import android.view.View
import androidx.lifecycle.*

class SignInViewModel(application: Application) : AndroidViewModel(application) {
    var context=application
    val email = MutableLiveData<String>()
    var paw = MutableLiveData<String>()
    private val firebaseRepository = FirebaseAccountRepository(application)
    init {
        onSignIn()

    }

    private fun onSignIn(){
        val accountDate:AccountDate = firebaseRepository.getDate()
        Log.e(accountDate.email,accountDate.password)

        if(accountDate.email != "")  singIn(accountDate.email,accountDate.password)

    }
    private fun singIn(email:String, password:String){
        firebaseRepository.singIn(email,password)

    }
    fun onSignInButton(view: View) {
        singIn(email.value.toString(),paw.value.toString())
        Log.e("이메일", email.value.toString())
        savaSignData()

    }
    fun onSignUpButton(view: View){
        firebaseRepository.sigUp(email.value.toString(),paw.value.toString())
        Log.e(email.value,paw.value.toString())
        savaSignData()
    }

    fun savaSignData() = firebaseRepository.setDate(email.value.toString(),paw.value.toString())



}