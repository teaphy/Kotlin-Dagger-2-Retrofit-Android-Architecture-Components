package com.example.administrator.archdemo.ui.login

import com.example.administrator.archdemo.ui.login.LoginActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * @desc
 * @author Tiany
 * @date 2017/7/10 0010
 */
@Subcomponent(modules = arrayOf(LoginModule::class))
interface LoginSubomponent : AndroidInjector<LoginActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<LoginActivity>()
}