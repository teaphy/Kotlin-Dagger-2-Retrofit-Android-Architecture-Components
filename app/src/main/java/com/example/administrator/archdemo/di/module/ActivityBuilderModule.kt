package com.example.administrator.archdemo.di.module

import com.example.administrator.archdemo.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @desc
 * @author Tiany
 * @date 2017/8/2 0002
 */
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(FragemtnBuilderModule::class))
    internal abstract fun contributeMainActivity(): MainActivity
}
