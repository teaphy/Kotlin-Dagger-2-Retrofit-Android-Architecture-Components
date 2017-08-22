package com.example.administrator.archdemo.repository

import android.arch.lifecycle.LiveData
import com.example.administrator.archdemo.api.ArchService
import com.example.administrator.archdemo.api.NetworkBoundResource
import com.example.administrator.archdemo.db.AppDatabase
import com.example.administrator.archdemo.entity.UserEntity
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @desc
 * @author Tiany
 * @date 2017/7/5 0005
 */
@Singleton
class UserRepository @Inject constructor(
        var archService: ArchService,
        var archDb: AppDatabase) {

    fun doLogin(name: String, pwd: String): LiveData<UserEntity> {
        return object : NetworkBoundResource<UserEntity, UserEntity>() {
            override fun createCall(): Flowable<UserEntity> {
                return archService.doLogin()
            }

            override fun shouldFetch(): Boolean {
                return true
            }

            override fun processResponse(response: UserEntity): UserEntity {
                return response
            }

            override fun loadFromDb(): LiveData<UserEntity> {
                return archDb.userDao().queryByName(name)
            }

            override fun saveCallResult(item: UserEntity) {
                archDb.userDao().insertUser(item)
            }

            override fun onFetchFailed() {
            }

        }.asLiveData()
    }
}

