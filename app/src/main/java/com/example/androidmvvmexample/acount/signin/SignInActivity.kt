package com.example.androidmvvmexample.acount.signin

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.androidmvvmexample.R
import com.example.androidmvvmexample.databinding.ActivityMainBinding
import com.example.androidmvvmexample.databinding.ActivitySigninBinding

class SignInActivity : AppCompatActivity() {
    private var mBinding: ActivitySigninBinding? = null

    private lateinit var signInViewModel: SignInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_signin);
        initViewModel()

    }

    private fun initViewModel() {
        signInViewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
        mBinding!!.accountModel=signInViewModel



    }

}