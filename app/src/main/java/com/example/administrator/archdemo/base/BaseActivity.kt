package com.example.administrator.archdemo.base

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

/**
 * @desc
 * @author Teaphy
 * @date 2017/6/6
 */
abstract class BaseActivity : AppCompatActivity() {



	override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
		super.onCreate(savedInstanceState)
		setContentView(getLayoutId())



		initData()

		initView()

		setListener()
	}

	abstract fun getLayoutId(): Int

	abstract fun initData()

	abstract fun initView()

	abstract fun setListener()

}