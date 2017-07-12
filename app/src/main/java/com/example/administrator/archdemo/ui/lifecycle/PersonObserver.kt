package com.example.administrator.archdemo.ui.lifecycle

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log

/**
 * @desc
 * @author Tiany
 * @date 2017/7/12 0012
 */
class PersonObserver(val lifecycle: Lifecycle) : LifecycleObserver {

    fun initObserver() {
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {

        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i("tea", "PersonObserver - onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i("tea", "PersonObserver - onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i("tea", "PersonObserver - onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i("tea", "PersonObserver - onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i("tea", "PersonObserver - onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i("tea", "PersonObserver - onDestroy")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {
        Log.i("tea", "PersonObserver - onAny")
    }
}