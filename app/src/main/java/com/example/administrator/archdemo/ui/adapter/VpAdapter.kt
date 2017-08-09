package com.example.administrator.archdemo.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * @desc ViewPager Fragment Adpater
 * @author Tiany
 * @date 2017/8/2 0002
 */
class VpAdapter(fragmentManager: FragmentManager, val titles: List<String>, val fragments: List<Fragment>) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }


    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}