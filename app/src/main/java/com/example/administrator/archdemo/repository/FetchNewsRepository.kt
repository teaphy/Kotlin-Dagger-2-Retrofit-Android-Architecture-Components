package com.example.administrator.archdemo.repository

import android.arch.lifecycle.LiveData
import android.util.Log
import com.example.administrator.archdemo.api.ArchService
import com.example.administrator.archdemo.api.NetworkBoundResource
import com.example.administrator.archdemo.base.CommonResult
import com.example.administrator.archdemo.entity.NewsEntity
import io.reactivex.Flowable
import org.w3c.dom.Entity
import javax.inject.Inject

/**
 * @desc
 * @author Tiany
 * @date 2017/8/7 0007
 */
class FetchNewsRepository @Inject constructor(val archService: ArchService) {

    fun fetchNews(params: Map<String, String>): LiveData<List<NewsEntity>> {

        Log.i("123", "FetchNewsRepository - fetchNews")

        return object : NetworkBoundResource<List<NewsEntity>, CommonResult<NewsEntity>>() {
            override fun createCall(): Flowable<CommonResult<NewsEntity>> {
                return archService.queryNews(params)
            }

            override fun shouldFetch(): Boolean {
                return true
            }

            override fun processResponse(response: CommonResult<NewsEntity>): List<NewsEntity>? {
                return response.result.result.list
            }

            override fun loadFromDb(): LiveData<List<NewsEntity>> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun saveCallResult(item: List<NewsEntity>) {

            }

            override fun onFetchFailed() {

            }

        }.asLiveData()
    }
}