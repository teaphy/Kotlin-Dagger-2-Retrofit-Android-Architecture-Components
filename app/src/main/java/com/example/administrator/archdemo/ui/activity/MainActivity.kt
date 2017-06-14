package com.example.administrator.archdemo.ui.activity

import android.os.Bundle
import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.base.BaseActivity

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
    
    override fun initTitle(): CharSequence? {
        return getString(R.string.app_name)
    }
    
    override fun initData() {
	   
    }
    
    override fun initView() {
    }
    
    override fun setListener() {
	    acb_room.setOnClickListener{
		    startActivity<RoomActivity>()
	    }

    }
    
}
