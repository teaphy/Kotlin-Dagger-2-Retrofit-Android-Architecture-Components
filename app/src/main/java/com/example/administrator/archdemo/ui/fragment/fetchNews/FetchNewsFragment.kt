package com.example.administrator.archdemo.ui.fragment.fetchNews


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.base.BaseFragment
import com.example.administrator.archdemo.entity.NewsEntity
import com.example.administrator.archdemo.global.KeyObject
import com.example.administrator.archdemo.ui.adapter.NewsAdapter
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.android.synthetic.main.fragment_fetch_news.*
import javax.inject.Inject

/**
 * 新闻列表
 */
class FetchNewsFragment : BaseFragment(), FetchNewsView {

    private lateinit var mNewsColumn: String

    @Inject
    lateinit var mArchVModelFactory: ViewModelProvider.Factory

    private lateinit var mFetchNewsVModel: FetchNewsVModel

    private var mListNews: MutableList<NewsEntity> = mutableListOf()

    // 当前页数
    var mPageSize: Int = 1

    private var isRefresh: Boolean = false
    private var isLoading: Boolean = false

    private lateinit var mNewsAdapter: NewsAdapter

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

        mFetchNewsVModel.attechView(this)

        // 获取相关的LiveData实例并监测
        mFetchNewsVModel.fetchNews().observe(this, Observer {
            if (mPageSize == 1) {
                if (null != it) {
                    mListNews.clear()
                    mListNews.addAll(it)
                    mNewsAdapter.notifyDataSetChanged()
                }

            } else {
                val oldPos = mListNews.size
                mListNews.addAll(it!!)
                mNewsAdapter.notifyItemRangeInserted(oldPos, it?.size)
            }

            mPageSize++
            updateFetchStatus()
        })

        mFetchNewsVModel.updatePage(pageSize = 1)
    }

    private fun initView() {

        // 设置RecyclerView
        val manager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvNews.layoutManager = manager
        rvNews.adapter = mNewsAdapter
        rvNews.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        // 设置SwipeRefreshLayout
        srlNews.setColorSchemeColors(resources.getColor(R.color.colorPrimary))
    }

    private fun setListener() {
        srlNews.setOnRefreshListener {
            if (!isLoading) {
                isLoading = true
                isRefresh = true
                mPageSize = 1
                mFetchNewsVModel.updatePage(mPageSize)
            }

        }

        rvNews.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!isLoading) {
                    val layoutManager = recyclerView!!.layoutManager as LinearLayoutManager
                    val lastPosition = layoutManager
                            .findLastVisibleItemPosition()
                    if (lastPosition == mNewsAdapter.itemCount - 1) {
                        isLoading = true
                        isRefresh = false
                        mFetchNewsVModel.updatePage(mPageSize)
                    }
                }
            }
        })
    }

    override fun provideChannel(): String {
        return mNewsColumn
    }

    override fun fetchNewsFailure() {
       updateFetchStatus()
    }

    private fun updateFetchStatus() {
        isLoading = false

        if (isRefresh) {
            if (srlNews.isRefreshing) {
                srlNews.isRefreshing = false
            }
        } else {

        }
    }
}
