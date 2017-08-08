package com.example.administrator.archdemo.base

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.support.v4.app.Fragment
import com.example.administrator.archdemo.di.Injectable

/**
 * @desc
 * @author Tiany
 * @date 2017/8/7 0007
 */
open class BaseFragment :  Fragment(), Injectable, LifecycleRegistryOwner {

    val mRegistry: LifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry {
        return mRegistry
    }
}