package com.example.administrator.archdemo.ui.login

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.administrator.archdemo.ArchApp
import com.example.administrator.archdemo.entity.UserEntity
import com.example.administrator.archdemo.repository.LoginRepository
import javax.inject.Inject

/**
 * @desc
 * @author Tiany
 * @date 2017/6/26 0026
 */
class LoginViewModel(archApp: Application) : AndroidViewModel(archApp) {

    lateinit var usrLiveData: LiveData<List<UserEntity>>

    @Inject
    constructor(archApp: Application, loginRepository: LoginRepository) : this(archApp)


}