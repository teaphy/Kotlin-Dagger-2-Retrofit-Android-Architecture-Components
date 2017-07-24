/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.administrator.archdemo

import com.example.administrator.archdemo.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import android.app.Application
import com.example.administrator.archdemo.base.AppManager
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class ArchApp : DaggerApplication() {

    @Inject
    @JvmField
    var dispatchingActivityInjector: DispatchingAndroidInjector<DaggerApplication>? = null

    @Inject
    var mAppManager: AppManager? = null

    var mApplication: Application? = null

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
        }

        mApplication = this

        AppInjector.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return dispatchingActivityInjector
    }

    /**
     * 程序终止的时候执行
     */
    override fun onTerminate() {
        super.onTerminate()

        if (mAppManager != null) {//释放资源
            this.mAppManager?.release()
            this.mAppManager = null
        }
        if (mApplication != null)
            this.mApplication = null
    }
}