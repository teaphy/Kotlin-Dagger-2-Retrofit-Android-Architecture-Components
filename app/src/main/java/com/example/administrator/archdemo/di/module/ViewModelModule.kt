package com.example.administrator.archdemo.di.module

import android.arch.lifecycle.ViewModel
import com.example.administrator.archdemo.di.animotion.ViewModelKey
import com.example.administrator.archdemo.ui.login.LoginViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @desc
 * @author Tiany
 * @date 2017/7/5 0005
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel
}