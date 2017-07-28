package com.example.administrator.archdemo.di.component

import android.app.Application
import com.example.administrator.archdemo.ArchApp
import com.example.administrator.archdemo.bean.Dog
import com.example.administrator.archdemo.di.module.AppModule
import com.example.administrator.archdemo.di.module.LoginModule
import com.example.administrator.archdemo.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        LoginModule::class))
interface ArchComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ArchComponent
    }

    fun inject(archApp: ArchApp)
}