package com.example.administrator.archdemo.ui.fragment.fetchNews

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.example.administrator.archdemo.entity.NewsEntity
import com.example.administrator.archdemo.global.CommonObject
import com.example.administrator.archdemo.listener.impl.SimpleNetworkListener
import com.example.administrator.archdemo.repository.FetchNewsRepository
import javax.inject.Inject

/**
 * @desc
 * @author Tiany
 * @date 2017/8/7 0007
 */
class FetchNewsVModel @Inject constructor(val fetchNewsRepository: FetchNewsRepository) : ViewModel() {
    private var newsLiveData: LiveData<List<NewsEntity>>
    private val pageLiveData: MutableLiveData<Int> = MutableLiveData()

    private lateinit var newsView: FetchNewsView

    init {
        newsLiveData = Transformations.switchMap(pageLiveData){
            page ->
            fetchNewsRepository.fetchNews(configParas(newsView.provideChannel(), page), object : SimpleNetworkListener(){
                override fun fetchFailed() {
                    super.fetchFailed()
                    newsView.fetchNewsFailure()
                }
            })
        }
    }

    fun fetchNews(): LiveData<List<NewsEntity>> {
        return newsLiveData
    }

    fun updatePage(pageSize: Int) {
        pageLiveData.value = pageSize
    }

    private fun configParas(channel: String, pageSize: Int): Map<String, String> {
        val start = CommonObject.PAGE_SIZE * (pageSize - 1)

        return mapOf("appkey" to CommonObject.KEY_APP_JDWX,
                "channel" to channel,
                "num" to CommonObject.PAGE_SIZE.toString(),
                "start" to start.toString())
    }

    fun attechView(view: FetchNewsView) {
        this.newsView = view
    }
}