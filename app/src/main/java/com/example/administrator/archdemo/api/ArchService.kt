package com.example.administrator.archdemo.api

import android.arch.lifecycle.LiveData
import com.example.administrator.archdemo.entity.UserEntity
import com.example.administrator.archdemo.global.UrlObject
import retrofit2.Call
import retrofit2.http.GET

/**
 * @desc
 * @author Tiany
 * @date 2017/6/26 0026
 */
interface ArchService {
    @GET(UrlObject.USER)
    fun getData(): Call<UserEntity>
}