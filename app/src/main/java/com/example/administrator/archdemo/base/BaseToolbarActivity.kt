package com.example.administrator.archdemo.base

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.administrator.archdemo.R
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector

import kotlinx.android.synthetic.main.layout_toolbar.*
import javax.inject.Inject

/**
 * @desc
 * @author Teaphy
 * @date 2017/6/6
 */
abstract class BaseToolbarActivity : BaseActivity() {


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		initToolbar()
	}

	private fun initToolbar() {
		toolbar.title = initTitle()
		toolbar.setTitleTextColor(resources.getColor(android.R.color.white))

		toolbar.navigationIcon = resources.getDrawable(R.mipmap.ic_back)

		setSupportActionBar(toolbar)

		toolbar.setNavigationOnClickListener{
			finish()
		}
	}

    abstract fun initTitle(): CharSequence?
}