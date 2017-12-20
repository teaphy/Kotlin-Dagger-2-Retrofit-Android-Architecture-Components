package com.example.administrator.archdemo.di.module


import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.administrator.archdemo.di.animotion.ViewModelKey
import com.example.administrator.archdemo.ui.fragment.fetchNews.FetchNewsVModel
import com.example.administrator.archdemo.viewmodel.ArchViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @desc
 * @author Tiany
 * @date 2017/7/5 0005
 */
@Module
abstract class ViewModelModule {

    // 将View添加到Map
    @Binds
    @IntoMap
    @ViewModelKey(FetchNewsVModel::class)
    abstract fun bindFetechNewsVModell(fetchNewsVModel: FetchNewsVModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: ArchViewModelFactory): ViewModelProvider.Factory
}