package com.example.administrator.archdemo.di.component

import android.app.Application
import com.example.administrator.archdemo.di.module.ActivityBuilderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * @desc
 * @author Tiany
 * @date 2017/7/4 0004
 */
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        ActivityBuilderModule::class))
interface ArchComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        abstract fun application(application: Application): Builder
        abstract fun build(): ArchComponent
    }

    fun inject(application: Application)
}