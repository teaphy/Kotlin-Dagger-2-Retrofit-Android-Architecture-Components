package com.example.administrator.archdemo.repository

import com.example.administrator.archdemo.AppExecutors
import com.example.administrator.archdemo.api.ArchService
import com.example.administrator.archdemo.db.AppDatabase
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

}

