package com.example.administrator.archdemo.api

import android.arch.lifecycle.LiveData
import com.example.administrator.archdemo.base.CommonResult
import com.example.administrator.archdemo.entity.NewsEntity
import com.example.administrator.archdemo.entity.UserEntity
import com.example.administrator.archdemo.global.UrlObject
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * @desc
 * @author Tiany
 * @date 2017/6/26 0026
 */
interface ArchService {
    @GET(UrlObject.USER)
    fun doLogin(): Flowable<UserEntity>

    @GET(UrlObject.QUERY_NEWS)
    fun queryNews(@QueryMap params: Map<String, String> ): Flowable<CommonResult<NewsEntity>>

}