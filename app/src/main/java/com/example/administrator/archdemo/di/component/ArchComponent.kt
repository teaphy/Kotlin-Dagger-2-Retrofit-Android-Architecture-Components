package com.example.administrator.archdemo.di.component

import com.example.administrator.archdemo.ArchApp
import com.example.administrator.archdemo.di.module.AppModule
import com.example.administrator.archdemo.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ViewModelModule::class))
interface ArchComponent : AndroidInjector<ArchApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ArchApp>()
}