package com.example.administrator.archdemo.ui.login

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.administrator.archdemo.ArchApp
import com.example.administrator.archdemo.entity.UserEntity
import com.example.administrator.archdemo.repository.UserRepository
import javax.inject.Inject

/**
 * @desc
 * @author Tiany
 * @date 2017/6/26 0026
 */
class LoginViewModel @Inject constructor(var userRepository: UserRepository) : ViewModel() {

    lateinit var userLiveData: LiveData<UserEntity>

    fun doLogin(userName: String, pwd: String) {
       userLiveData =  userRepository?.doLogin(userName, pwd)
    }
}