package com.example.administrator.archdemo.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.administrator.archdemo.bean.Dog
import com.example.administrator.archdemo.di.animotion.ViewModelKey
import com.example.administrator.archdemo.ui.login.LoginViewModel
import com.example.administrator.archdemo.viewmodel.ArchViewModelFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.Multibinds
import dagger.multibindings.StringKey
import javax.inject.Provider


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

//    @Binds
//    abstract fun bindViewModelFactory(factory: ArchViewModelFactory): ViewModelProvider.Factory

//    @Binds
//    @IntoMap
//    @StringKey("A")
//    abstract fun bindDog(dog: Dog)
}