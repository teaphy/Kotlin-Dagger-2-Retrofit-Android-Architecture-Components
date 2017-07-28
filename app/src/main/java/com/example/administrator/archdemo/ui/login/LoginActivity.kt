package com.example.administrator.archdemo.ui.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.TextUtils
import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.base.BaseActivity
import com.example.administrator.archdemo.bean.Dog
import com.example.administrator.archdemo.db.AppDatabase
import com.example.administrator.archdemo.entity.UserEntity
import com.example.administrator.archdemo.viewmodel.ArchViewModelFactory
import com.example.administrator.archdemo.viewmodel.TestFactory
import com.example.administrator.archdemo.viewmodel.TestFactory_Factory
import dagger.android.AndroidInjection

import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast
import javax.inject.Inject
import javax.inject.Provider


class LoginActivity : BaseActivity() {

    @Inject
    lateinit var archFatcory: ArchViewModelFactory

    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setListener()
    }


    override fun onStart() {
        super.onStart()

//        loginViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)

//        loginViewModel.userLiveData.observe(this, Observer<UserEntity> {
//            toast("$it")
//        })
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }


    override fun initData() {

    }

    override fun initView() {
    }


    override fun setListener() {
        acb_login.setOnClickListener {
            doLogin()
        }
    }

    private fun doLogin() {
        val name = edit_id.text.toString()
        val pwd = edit_password.toString()

        if (TextUtils.isEmpty(name)) {
            toast(R.string.prompt_input_id)
        } else if (TextUtils.isEmpty(pwd)) {
            toast(R.string.prompt_intput_pwd)
        } else {
            loginViewModel.doLogin(name, pwd)
        }
    }
}
