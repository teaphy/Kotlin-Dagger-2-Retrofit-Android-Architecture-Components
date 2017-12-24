package com.example.administrator.archdemo.ui.main

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.base.BaseHasFragmentActivity
import com.example.administrator.archdemo.entity.TestEntity
import com.example.administrator.archdemo.ui.adapter.VpAdapter
import com.example.administrator.archdemo.ui.fragment.collectionNews.CollectionNewsFragment
import com.example.administrator.archdemo.ui.fragment.fetchNews.FetchNewsFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : BaseHasFragmentActivity() {

    val mListTitle: MutableList<String> =  mutableListOf()
    val mListFragment: MutableList<Fragment> = mutableListOf()
    lateinit var vpAdapter: VpAdapter

    @Inject
    lateinit var testEntity: TestEntity
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
         toast(testEntity.number.toString())
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
                mListFragment.add(CollectionNewsFragment.newInstance(title))
            }
        }
    }

    override fun initView() {
        vpAdapter = VpAdapter(supportFragmentManager, mListTitle, mListFragment)
        vpNews.adapter = vpAdapter
        tabNews.tabMode = TabLayout.MODE_FIXED
        tabNews.setupWithViewPager(vpNews)

        vpNews.offscreenPageLimit = mListTitle.size
    }
    
    override fun setListener() {

    }
}
