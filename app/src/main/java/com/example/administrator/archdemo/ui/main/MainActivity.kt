package com.example.administrator.archdemo.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.base.BaseHasFragmentActivity
import com.example.administrator.archdemo.ui.adapter.VpAdapter
import com.example.administrator.archdemo.ui.fragment.collectionNews.CollectionNewsFragment
import com.example.administrator.archdemo.ui.fragment.fetchNews.FetchNewsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseHasFragmentActivity() {

    val mListTitle: MutableList<String> =  mutableListOf()
    val mListFragment: MutableList<Fragment> = mutableListOf()
    lateinit var vpAdapter: VpAdapter
    
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
        mListTitle.addAll(resources.getStringArray(R.array.arrayNewsColumn))
        mListTitle.forEachIndexed {
            pos, title ->
            if (pos < mListTitle.size - 1) {
                mListFragment.add(FetchNewsFragment.newInstance(title))
            } else {
                mListFragment.add(CollectionNewsFragment())
            }
        }
    }

    override fun initView() {
        vpAdapter = VpAdapter(supportFragmentManager, mListTitle, mListFragment)
        vpNews.adapter = vpAdapter
        tabNews.setupWithViewPager(vpNews)
    }
    
    override fun setListener() {

    }
}
