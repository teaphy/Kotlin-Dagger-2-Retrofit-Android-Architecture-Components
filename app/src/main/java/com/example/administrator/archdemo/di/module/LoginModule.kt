package com.example.administrator.archdemo.di.module

import com.example.administrator.archdemo.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

/**
 * @desc
 * @author Tiany
 * @date 2017/7/26 0026
 */
@Module
abstract class LoginModule {
    @ContributesAndroidInjector
    abstract fun contributesLoginActivity(): LoginActivity
}