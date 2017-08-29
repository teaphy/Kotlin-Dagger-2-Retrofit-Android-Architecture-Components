package com.example.administrator.archdemo.repository

import android.arch.lifecycle.LiveData
import android.util.Log
import com.example.administrator.archdemo.AppExecutors
import com.example.administrator.archdemo.api.ArchService
import com.example.administrator.archdemo.api.NetworkBoundResource
import com.example.administrator.archdemo.base.CommonResult
import com.example.administrator.archdemo.db.AppDatabase
import com.example.administrator.archdemo.entity.NewsEntity
import com.example.administrator.archdemo.listener.NetworkListener
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @desc
 * @author Tiany
 * @date 2017/8/7 0007
 */
class FetchNewsRepository @Inject constructor(val archService: ArchService, val appDatabase: AppDatabase, val appExecutors: AppExecutors) {

    fun fetchNews(params: Map<String, String>, netwrokListener: NetworkListener): LiveData<List<NewsEntity>> {

        Log.i("123", "FetchNewsRepository - fetchNews")

        return object : NetworkBoundResource<List<NewsEntity>, CommonResult<NewsEntity>>() {
            override fun createCall(): Flowable<CommonResult<NewsEntity>> {
                return archService.queryNews(params)
            }

            override fun processResponse(response: CommonResult<NewsEntity>): List<NewsEntity>? {
                return response.result.result.list
            }

            /**
             *  将新闻信息保存到数据库
             */
            override fun saveCallResult(item: List<NewsEntity>) {
                appExecutors.diskIO().execute{
                    val news = appDatabase.newsDao().queryAllNewsForList()
                    appDatabase.newsDao().deleteAll(news = news)
                    appDatabase.newsDao().insertNews(item)
                }
            }

            override fun onFetchFailed() {
                netwrokListener.fetchFailed()
            }

        }.asLiveData()
    }

    fun loadNewsFromDb(): LiveData<List<NewsEntity>> {
        return appDatabase.newsDao().queryAllNews()
    }
}