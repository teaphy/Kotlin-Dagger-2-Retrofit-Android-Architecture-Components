package com.example.administrator.archdemo.di.module

import android.app.Activity
import com.example.administrator.archdemo.ui.login.LoginSubomponent
import com.example.administrator.archdemo.ui.login.LoginActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * @desc
 * @author Tiany
 * @date 2017/7/10 0010
 */
@Module(subcomponents = arrayOf(LoginSubomponent::class))
abstract class ActivityBuilderModule {

    @Binds
    @IntoMap
    @ActivityKey(value = LoginActivity::class)
    abstract fun bindLoginActivityInjectorFactory(builder: LoginSubomponent.Builder) : AndroidInjector.Factory<out Activity>
}