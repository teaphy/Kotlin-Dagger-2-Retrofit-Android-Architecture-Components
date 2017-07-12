package com.example.administrator.archdemo.ui.login

import android.os.Bundle
import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.base.BaseActivity
import com.example.administrator.archdemo.ui.activity.MainActivity
import com.example.administrator.archdemo.ui.lifecycle.PersonActivity

import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setListener()
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
        startActivity<PersonActivity>()
    }
}
