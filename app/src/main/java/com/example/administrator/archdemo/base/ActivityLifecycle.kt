package com.example.administrator.archdemo.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.example.administrator.archdemo.di.Injectable
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection

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
        handleActivity(activity)
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

    private fun handleActivity(activity: Activity) {

        AndroidInjection.inject(activity)

        (activity as? FragmentActivity)?.supportFragmentManager?.registerFragmentLifecycleCallbacks(
                object : FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentCreated(fm: FragmentManager?, f: Fragment?,
                                                   savedInstanceState: Bundle?) {
                        if (null != f && f is Injectable) {
                            AndroidSupportInjection.inject(f)
                        }
                    }
                }, true)
    }
}
