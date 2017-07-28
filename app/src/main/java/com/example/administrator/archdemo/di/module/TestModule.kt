package com.example.administrator.archdemo.di.module

import com.example.administrator.archdemo.bean.Dog
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

/**
 * @desc
 * @author Tiany
 * @date 2017/7/28 0028
 */

@Module
abstract class TestModule {

    @Binds
    @IntoMap
    @StringKey("A")
    abstract fun provideTest(dog: Dog): Dog
}