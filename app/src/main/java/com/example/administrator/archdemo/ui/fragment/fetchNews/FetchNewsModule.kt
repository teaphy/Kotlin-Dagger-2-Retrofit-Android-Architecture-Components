package com.example.administrator.archdemo.ui.fragment.fetchNews

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module

/**
 * @desc
 * @author Tiany
 * @date 2017/8/22 0022
 */
@Module
abstract class FetchNewsModule {

    @Binds
    abstract fun bindFetchNewsFragment(fetchNewsFragment: FetchNewsFragment): Fragment

    @Binds
    abstract fun bindFetchNewsView(fetchNewsFragment: FetchNewsFragment): FetchNewsView
}