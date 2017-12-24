package com.example.administrator.archdemo.di.component

import com.example.administrator.archdemo.ArchApp
import com.example.administrator.archdemo.di.module.ActivityBuilderModule
import com.example.administrator.archdemo.di.module.AppModule
import com.example.administrator.archdemo.di.module.TestModule
import com.example.administrator.archdemo.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, TestModule::class, ActivityBuilderModule::class, AppModule::class, ViewModelModule::class])
interface ArchComponent : AndroidInjector<ArchApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ArchApp>() {

	    abstract fun testModule(testModule: TestModule): Builder
    }
}