package com.example.administrator.archdemo.di.module


import android.arch.lifecycle.ViewModelProvider
import com.example.administrator.archdemo.viewmodel.ArchViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * @desc
 * @author Tiany
 * @date 2017/7/5 0005
 */
@Module
abstract class ViewModelModule {


    @Binds
    abstract fun bindViewModelFactory(factory: ArchViewModelFactory): ViewModelProvider.Factory
}