package com.example.administrator.archdemo.ui.lifecycle

import android.arch.lifecycle.LiveData
import android.util.Log

/**
 * @desc
 * @author Tiany
 * @date 2017/7/17 0017
 */
class PersonLiveData : LiveData<Person>() {

    override fun onActive() {
        super.onActive()
        Log.d("tea", "onActive")
    }

    override fun onInactive() {
        super.onInactive()
        Log.d("tea", "onInactive")
    }

    public override fun postValue(value: Person?) {
        super.postValue(value)
    }

    public override fun setValue(value: Person?) {
        super.setValue(value)
    }
}