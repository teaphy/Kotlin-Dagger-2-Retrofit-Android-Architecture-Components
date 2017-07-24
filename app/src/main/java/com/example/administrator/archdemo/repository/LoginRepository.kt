package com.example.administrator.archdemo.repository

import android.util.Log
import com.example.administrator.archdemo.AppExecutors
import com.example.administrator.archdemo.api.ArchService
import com.example.administrator.archdemo.db.AppDatabase
import com.example.administrator.archdemo.entity.UserEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @desc
 * @author Tiany
 * @date 2017/7/5 0005
 */
@Singleton
class LoginRepository @Inject constructor(private val appExecutors: AppExecutors,
                      private val archService: ArchService,
                      private val archDb: AppDatabase) {

    fun doLogin(name: String, pwd: String) {

    }
}

