package com.example.administrator.archdemo.ui.fragment

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.example.administrator.archdemo.entity.NewsEntity
import com.example.administrator.archdemo.global.CommonObject
import com.example.administrator.archdemo.listener.impl.SimpleNetworkListener
import com.example.administrator.archdemo.repository.FetchNewsRepository
import com.example.administrator.archdemo.ui.fragment.fetchNews.FetchNewsView
import javax.inject.Inject

/**
 * @desc
 * @author Tiany
 * @date 2017/8/7 0007
 */
class CollectNewsVModel : ViewModel() {
    private val collectLiveData: MutableLiveData<NewsEntity> = MutableLiveData()

    fun collectNews(newsEntity: NewsEntity) {
        collectLiveData.value = newsEntity
    }

    fun getCollectLiveData(): LiveData<NewsEntity> {
        return collectLiveData
    }
}