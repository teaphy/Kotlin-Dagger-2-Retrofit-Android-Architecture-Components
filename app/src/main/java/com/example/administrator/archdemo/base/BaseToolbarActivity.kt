package com.example.administrator.archdemo.base

import android.os.Bundle
import com.example.administrator.archdemo.R
import kotlinx.android.synthetic.main.layout_toolbar.*

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