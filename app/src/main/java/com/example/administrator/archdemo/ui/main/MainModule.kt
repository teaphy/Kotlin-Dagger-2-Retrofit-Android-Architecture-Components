package com.example.administrator.archdemo.ui.main

import android.app.Activity
import com.example.administrator.archdemo.ui.fragment.fetchNews.FetchNewsFragment
import com.example.administrator.archdemo.ui.fragment.fetchNews.FetchNewsModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @desc
 * @author Tiany
 * @date 2017/8/22 0022
 */
@Module
abstract class MainModule {


    @ContributesAndroidInjector(modules = arrayOf(FetchNewsModule::class))
    abstract fun bindFetchNewsFragment(): FetchNewsFragment

    @Binds
    abstract fun bindsMainActivity(activity: MainActivity): Activity
}