package com.example.administrator.archdemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.administrator.archdemo.R

import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 * @desc
 * @author Teaphy
 * @date 2017/6/6
 */
abstract class BaseActivity : AppCompatActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(getLayoutId())
		
		initToolbar()
		
		initData()
		
		initView()
		
		setListener()
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
	abstract fun getLayoutId(): Int
	
	abstract fun initTitle(): CharSequence?
	
	abstract fun initData()
	
	abstract fun initView()
	
	abstract fun setListener()
}