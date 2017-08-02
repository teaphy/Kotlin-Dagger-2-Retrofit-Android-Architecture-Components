package com.example.administrator.archdemo.di.module

import com.example.administrator.archdemo.ui.fragment.collectionNews.CollectionNewsFragment
import com.example.administrator.archdemo.ui.fragment.fetchNews.FetchNewsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @desc
 * @author Tiany
 * @date 2017/8/2 0002
 */
@Module
abstract class FragemtnBuilderModule {

    @ContributesAndroidInjector
    abstract fun bindCollectionNewsFragment(): CollectionNewsFragment

    @ContributesAndroidInjector
    abstract fun bindFetchNewsFragment(): FetchNewsFragment
}