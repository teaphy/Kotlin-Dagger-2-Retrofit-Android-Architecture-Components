package com.example.administrator.archdemo.api

import android.arch.lifecycle.LiveData
import android.support.annotation.MainThread

/**
 * @desc
 * @author Tiany
 * @date 2017/8/22 0022
 */
abstract class SimpleNetworkResource<ResultType, RequestType> @MainThread constructor() : NetworkBoundResource<ResultType, RequestType>() {

    /**
     * 默认从网络获取数据
     */
    override fun shouldFetch(): Boolean {
        return true
    }

    override fun loadFromDb(): LiveData<ResultType> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveCallResult(item: ResultType) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}