package com.example.administrator.archdemo.base

import android.app.Activity
import android.arch.lifecycle.LifecycleRegistryOwner
import android.content.Context
import android.os.Build
import dagger.android.support.AndroidSupportInjection


/**
 * @desc
 * @author Tiany
 * @date 2017/8/7 0007
 */
open class BaseFragment : BaseLifecycleFragment(), LifecycleRegistryOwner {

    @SuppressWarnings("deprecation")
    override fun onAttach(activity: Activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            // Perform injection here before M, L (API 22) and below because onAttach(Context)
            // is not yet available at L.
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(activity)
    }

    override fun onAttach(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Perform injection here for M (API 23) due to deprecation of onAttach(Activity).
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(context)
    }
}