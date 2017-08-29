package com.example.administrator.archdemo.ui.fragment.collectionNews


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.base.BaseLifecycleFragment
import com.example.administrator.archdemo.entity.NewsEntity
import com.example.administrator.archdemo.global.KeyObject
import com.example.administrator.archdemo.ui.adapter.NewsAdapter
import com.example.administrator.archdemo.ui.fragment.CollectNewsVModel
import kotlinx.android.synthetic.main.fragment_collection_news.*

/**
 * 收藏新闻列表
 */
class CollectionNewsFragment : BaseLifecycleFragment() {

    private lateinit var mCollectNewsVModel: CollectNewsVModel

    private lateinit var mNewsType: String

    private var mListNews: MutableList<NewsEntity> = mutableListOf()

    private lateinit var mNewsAdapter: NewsAdapter

    companion object {
        fun newInstance(newsType: String): CollectionNewsFragment {
            val frm = CollectionNewsFragment()
            val args = Bundle()
            args.putString(KeyObject.KEY_NEWS_COLUMN, newsType)
            frm.arguments = args
            return frm
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_collection_news, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initData()

        initView()

        setListener()

    }

    private fun initData() {

        mNewsType = arguments.getString(KeyObject.KEY_NEWS_COLUMN)

        mNewsAdapter = NewsAdapter(mListNews, context, mNewsType)

        // 这里使用Activity作为参数，是为了当前Activity中的Fragment之间的通信
        mCollectNewsVModel = ViewModelProviders.of(activity).get(CollectNewsVModel::class.java)

        mCollectNewsVModel.getCollectLiveData().observe(this, Observer {
            if (mListNews.contains(it!!)) {
                val posRemove = mListNews.indexOf(it)
                mListNews.remove(it)
                mNewsAdapter.notifyItemRemoved(posRemove)
            } else {
                val oldPos = mListNews.size - 1
                mListNews.add(it!!)
                mNewsAdapter.notifyItemInserted(oldPos)
            }
        })
    }

    private fun initView() {
        // 设置RecyclerView
        val manager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvNews.layoutManager = manager
        rvNews.adapter = mNewsAdapter
        rvNews.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    private fun setListener() {

    }
}
