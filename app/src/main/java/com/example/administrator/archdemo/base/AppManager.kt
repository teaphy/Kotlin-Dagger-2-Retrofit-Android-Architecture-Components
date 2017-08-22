package com.example.administrator.archdemo.base


import android.app.Activity
import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Message
import android.support.design.widget.Snackbar
import android.view.View
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


/**
 * 用于管理所有activity,和在前台的 activity
 * 可以通过直接持有AppManager对象执行对应方法
 * 也可以通过eventbus post事件,远程遥控执行对应方法
 */

@Singleton
class AppManager @Inject
constructor(private var mApplication: Application?) {
    protected val TAG = this.javaClass.simpleName

    //管理所有activity
    var mActivityList: MutableList<Activity>? = null
    //当前在前台的activity
    /**
     * 获得当前在前台的activity

     * @return
     */
    /**
     * 将在前台的activity保存

     * @param currentActivity
     */
    var currentActivity: Activity? = null

    private fun dispatchStart(message: Message) {
        if (message.obj is Intent)
            startActivity(message.obj as Intent)
        else if (message.obj is Class<*>)
            startActivity(message.obj as Class<*>)
        return
    }


    /**
     * 使用snackbar显示内容

     * @param message
     * *
     * @param isLong
     */
    fun showSnackbar(message: String, isLong: Boolean) {
        if (currentActivity == null) {
            return
        }
        val view = currentActivity!!.window.decorView.findViewById<View>(android.R.id.content)
        Snackbar.make(view, message, if (isLong) Snackbar.LENGTH_LONG else Snackbar.LENGTH_SHORT).show()
    }


    /**
     * 让在前台的activity,打开下一个activity

     * @param intent
     */
    fun startActivity(intent: Intent) {
        if (currentActivity == null) {
            //如果没有前台的activity就使用new_task模式启动activity
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            mApplication!!.startActivity(intent)
            return
        }
        currentActivity!!.startActivity(intent)
    }

    /**
     * 让在前台的activity,打开下一个activity

     * @param activityClass
     */
    fun startActivity(activityClass: Class<*>) {
        startActivity(Intent(mApplication, activityClass))
    }

    /**
     * 释放资源
     */
    fun release() {
        mActivityList!!.clear()
        mActivityList = null
        currentActivity = null
        mApplication = null
    }

    /**
     * 返回一个存储所有未销毁的activity的集合

     * @return
     */
    fun getActivityList(): MutableList<Activity>? {

        if (mActivityList == null) {
            mActivityList = mutableListOf()
        }
        return mActivityList
    }


    /**
     * 添加Activity到集合
     */
    fun addActivity(activity: Activity) {
        if (mActivityList == null) {
            mActivityList = LinkedList<Activity>()
        }
        synchronized(AppManager::class.java) {
            if (!mActivityList!!.contains(activity)) {
                mActivityList!!.add(activity)
            }
        }
    }

    /**
     * 删除集合里的指定activity

     * @param activity
     */
    fun removeActivity(activity: Activity) {
        if (mActivityList == null) {
            return
        }
        synchronized(AppManager::class.java) {
            if (mActivityList!!.contains(activity)) {
                mActivityList!!.remove(activity)
            }
        }
    }

    /**
     * 删除集合里的指定位置的activity

     * @param location
     */
    fun removeActivity(location: Int): Activity? {
        if (mActivityList == null) {
            return null
        }
        synchronized(AppManager::class.java) {
            if (location > 0 && location < mActivityList!!.size) {
                return mActivityList!!.removeAt(location)
            }
        }
        return null
    }

    /**
     * 关闭指定activity

     * @param activityClass
     */
    fun killActivity(activityClass: Class<*>) {
        if (mActivityList == null) {
            return
        }
        mActivityList!!
                .filter { it.javaClass == activityClass }
                .forEach { it.finish() }
    }


    /**
     * 指定的activity实例是否存活

     * @param activity
     * *
     * @return
     */
    fun activityInstanceIsLive(activity: Activity): Boolean {
        if (mActivityList == null) {
            return false
        }
        return mActivityList!!.contains(activity)
    }


    /**
     * 指定的activity class是否存活(一个activity可能有多个实例)

     * @param activityClass
     * *
     * @return
     */
    fun activityClassIsLive(activityClass: Class<*>): Boolean {
        if (mActivityList == null) {
            return false
        }

        return mActivityList!!.any {
            it.javaClass == activityClass
        }
    }


    /**
     * 关闭所有activity
     */
    fun killAll() {

        val iterator = mActivityList!!.iterator()
        while (iterator.hasNext()) {
            iterator.next().finish()
            iterator.remove()
        }
    }


    /**
     * 退出应用程序
     */
    fun AppExit() {
        try {
            killAll()
            if (mActivityList != null)
                mActivityList = null
            val activityMgr = mApplication!!.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            activityMgr.killBackgroundProcesses(mApplication!!.packageName)
            System.exit(0)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    companion object {
        val APPMANAGER_MESSAGE = "appmanager_message"
        val START_ACTIVITY = 0
        val SHOW_SNACKBAR = 1
        val KILL_ALL = 2
        val APP_EXIT = 3
    }
}