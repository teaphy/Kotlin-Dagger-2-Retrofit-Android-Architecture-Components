package com.example.administrator.archdemo.di.module

import android.app.Application
import android.arch.persistence.room.Room
import com.example.administrator.archdemo.api.ArchService
import com.example.administrator.archdemo.db.AppDatabase
import com.example.administrator.archdemo.global.DbObject
import com.example.administrator.archdemo.global.UrlObject
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * @desc
 * @author Tiany
 * @date 2017/7/4 0004
 */
@Module(includes = [(ActivityBuilderModule::class)])
class AppModule {

    @Singleton
    @Provides
    fun provideArchService(): ArchService {
        return Retrofit.Builder()
                .baseUrl(UrlObject.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ArchService::class.java!!)
    }

    @Singleton
    @Provides
    fun providerDb(app: Application): AppDatabase {
        return Room.databaseBuilder(app.applicationContext, AppDatabase::class.java!!, DbObject.NAME_DATABASE).build()
    }
}