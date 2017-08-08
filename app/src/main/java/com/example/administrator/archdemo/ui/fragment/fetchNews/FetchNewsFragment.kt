package com.example.administrator.archdemo.ui.fragment.fetchNews


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.base.BaseFragment
import com.example.administrator.archdemo.global.KeyObject
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

    override fun onResume() {
        super.onResume()

    }

    private fun initData() {
        mNewsColumn = arguments.getString(KeyObject.KEY_NEWS_COLUMN)

        tv_news.text = mNewsColumn

        mFetchNewsVModel = ViewModelProviders.of(this, mArchVModelFactory).get(FetchNewsVModel::class.java)

        mFetchNewsVModel.newsLiveData.observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })

        mFetchNewsVModel.fetchNews(mNewsColumn).observe(this, Observer {
            Log.i("123", "mFetchNewsVModel.fetchNews: $it")
        })
    }

}
