package com.example.administrator.archdemo.base

import android.app.Activity
import android.app.Application
import android.os.Bundle

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by jess on 21/02/2017 14:23
 * Contact with jess.yan.effort@gmail.com
 */
@Singleton
class ActivityLifecycle @Inject
constructor(private val mAppManager: AppManager) : Application.ActivityLifecycleCallbacks {

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        mAppManager.addActivity(activity)
    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityResumed(activity: Activity) {
        mAppManager.currentActivity = activity
    }

    override fun onActivityPaused(activity: Activity) {
        if (mAppManager.currentActivity === activity) {
            mAppManager.currentActivity = null
        }
    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {
        mAppManager.removeActivity(activity)
    }
}
