package com.example.administrator.archdemo.ui.fragment.fetchNews

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.administrator.archdemo.api.ArchService
import com.example.administrator.archdemo.entity.NewsEntity
import com.example.administrator.archdemo.global.CommonObject
import com.example.administrator.archdemo.repository.FetchNewsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject

/**
 * @desc
 * @author Tiany
 * @date 2017/8/7 0007
 */
class FetchNewsVModel @Inject constructor(val fetchNewsRepository: FetchNewsRepository) : ViewModel() {
    val newsLiveData: MutableLiveData<String> = MutableLiveData<String>()

    fun fetchNews(channel: String, pageSize: Int) : LiveData<List<NewsEntity>> {
        return fetchNewsRepository.fetchNews(configParas(channel, pageSize))
    }

    fun configParas(channel: String, pageSize: Int): Map<String, String> {
        val start = CommonObject.PAGE_SIZE * (pageSize - 1)

        var params: Map<String, String> =
                mapOf("appkey" to CommonObject.KEY_APP_JDWX,
                        "channel" to channel,
                        "num" to CommonObject.PAGE_SIZE.toString(),
                        "start" to start.toString())
        return params
    }

}