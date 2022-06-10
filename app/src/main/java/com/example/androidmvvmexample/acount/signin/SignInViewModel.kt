package com.example.androidmvvmexample.acount.signin

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.*

class SignInViewModel(application: Application) : AndroidViewModel(application) {
    val email = MutableLiveData<String>()
    var paw = MutableLiveData<String>()
    private val firebaseRepository = FirebaseAccountRepository(application)
    fun onSignIn(){
        var accountDate:AccountDate = firebaseRepository.getDate()
        if(accountDate.email != "")   firebaseRepository.singIn(accountDate.email,accountDate.password
        )

    }
    fun onSignInButton(view: View) {
        firebaseRepository.singIn(email.toString(),paw.toString())
        Log.e("이메일", email.value.toString())
        firebaseRepository.setDate(email.value.toString(),paw.value.toString())

    }
    fun onSignUpButton(view: View){
        firebaseRepository.sigUp(email.value.toString(),paw.value.toString())
        firebaseRepository.setDate(email.value.toString(),paw.value.toString())
    }

}