package com.example.administrator.archdemo.ui.fragment.fetchNews


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.base.BaseFragment
import com.example.administrator.archdemo.entity.NewsEntity
import com.example.administrator.archdemo.global.KeyObject
import com.example.administrator.archdemo.ui.adapter.NewsAdapter
import com.example.administrator.archdemo.viewmodel.ArchViewModelFactory

import kotlinx.android.synthetic.main.fragment_fetch_news.*
import javax.inject.Inject

/**
 * 新闻列表
 */
class FetchNewsFragment : BaseFragment() {

    lateinit var mNewsColumn: String

    @Inject
    lateinit var mArchVModelFactory: ViewModelProvider.Factory

    lateinit var mFetchNewsVModel : FetchNewsVModel

    var mListNews: MutableList<NewsEntity> = mutableListOf()

    // 当前页数
    var cPageSize: Int = 1

    lateinit var mNewsAdapter: NewsAdapter

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

        initView()

        setListener()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fetch_news, container, false)
    }

    override fun onResume() {
        super.onResume()

    }

    private fun initData() {
        mNewsColumn = arguments.getString(KeyObject.KEY_NEWS_COLUMN)

        mNewsAdapter = NewsAdapter(mListNews, context)

        // 获取相关的ViewModel实例
        mFetchNewsVModel = ViewModelProviders.of(this, mArchVModelFactory).get(FetchNewsVModel::class.java)

        mFetchNewsVModel.newsLiveData.observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })

        // 获取相关的LiveData实例并监测
        mFetchNewsVModel.fetchNews(mNewsColumn, cPageSize).observe(this, Observer {
            if (cPageSize == 1) {
                mListNews.clear()
                mListNews.addAll(it!!)
                mNewsAdapter.notifyDataSetChanged()
            } else {
                val oldPos = mListNews.size
                mListNews.addAll(it!!)
                mNewsAdapter.notifyItemRangeInserted(oldPos, it?.size)
            }
        })

    }

    private fun initView() {

        // 设置RecyclerView
        val manager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvNews.layoutManager =manager
        rvNews.adapter = mNewsAdapter
        rvNews.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        // 设置SwipeRefreshLayout
        srlNews.setColorSchemeColors(resources.getColor(R.color.colorPrimary))
    }

    private fun setListener() {
        srlNews.setOnRefreshListener{
            cPageSize = 1
        }
    }
}
