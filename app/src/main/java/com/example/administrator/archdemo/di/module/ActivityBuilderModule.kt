package com.example.administrator.archdemo.di.module

import android.app.Application
import com.example.administrator.archdemo.ArchApp
import com.example.administrator.archdemo.ui.main.MainActivity
import com.example.administrator.archdemo.ui.main.MainModule
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

/**
 * @desc
 * @author Tiany
 * @date 2017/8/2 0002
 */
@Module(includes = arrayOf(AndroidInjectionModule::class))
abstract class ActivityBuilderModule {

    @Binds
    @Singleton
    abstract fun application(app: ArchApp): Application

    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun contributeMainActivity(): MainActivity
}
