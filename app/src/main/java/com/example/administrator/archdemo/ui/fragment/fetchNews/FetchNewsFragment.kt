package com.example.administrator.archdemo.ui.fragment.fetchNews


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.global.KeyObject

import kotlinx.android.synthetic.main.fragment_fetch_news.*

/**
 * 新闻列表
 */
class FetchNewsFragment : Fragment() {

    lateinit var mNewsColumn: String

    companion object {
        fun newInstance(keyword: String): FetchNewsFragment {
            var frm = FetchNewsFragment()
            val args = Bundle()
            args.putString(KeyObject.KEY_NEWS_COLUMN, keyword)
            frm.arguments = args
            return frm
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initData()
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fetch_news, container, false)
    }

    private fun initData() {
        mNewsColumn = arguments.getString(KeyObject.KEY_NEWS_COLUMN)

        tv_news.text = mNewsColumn
    }

}
