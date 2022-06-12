package com.example.androidmvvmexample.acount.signin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidmvvmexample.R
import com.example.androidmvvmexample.databinding.ActivitySigninBinding


class SignInActivity : AppCompatActivity() {
    private var mBinding: ActivitySigninBinding? = null

    private lateinit var signInViewModel: SignInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_signin)
        signInViewModel = ViewModelProvider(this).get(SignInViewModel::class.java);
        initViewModel()



    }

    private fun initViewModel() {
        //signInViewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
        mBinding!!.accountModel=signInViewModel



    }


}