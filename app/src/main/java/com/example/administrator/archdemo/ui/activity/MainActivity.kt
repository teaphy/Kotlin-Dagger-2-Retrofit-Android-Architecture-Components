package com.example.administrator.archdemo.ui.activity

import android.os.Bundle
import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.base.BaseActivity
import com.example.administrator.archdemo.base.BaseToolbarActivity
import com.example.administrator.archdemo.ui.book.BookActivity

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : BaseToolbarActivity() {
    
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

        acb_book.setOnClickListener {
            startActivity<BookActivity>()
        }
    }
}
