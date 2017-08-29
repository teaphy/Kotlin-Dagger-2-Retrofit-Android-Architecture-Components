package com.example.administrator.archdemo.base

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.support.v4.app.Fragment

/**
 * @desc
 * @author Tiany
 * @date 2017/8/29 0029
 */
open class BaseLifecycleFragment : Fragment(), LifecycleRegistryOwner {
    val mRegistry: LifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry {
        return mRegistry
    }
}