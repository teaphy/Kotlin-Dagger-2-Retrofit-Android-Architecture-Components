package com.example.administrator.archdemo.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.entity.NewsEntity

import kotlinx.android.synthetic.main.item_news.view.*

/**
 * @desc This is for display the news
 * @author Tiany
 * @date 2017/8/9 0009
 */
class NewsAdapter(val list: List<NewsEntity>, val context: Context) : RecyclerView.Adapter<NewsAdapter.MyHolder>(){

    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
        val news = list[position]
        holder?.tvTitle?.text = news.title
        holder?.tvTime?.text = news.time

        val ro: RequestOptions = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.DATA)

        Glide.with(context)
                .load(news.pic)
                .apply(ro)
                .into(holder?.ivNews)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false)

        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        val ivNews: ImageView
        val tvTitle: TextView
        val tvTime: TextView

        init {
            ivNews = item.findViewById(R.id.ivNews)
            tvTitle = item.findViewById(R.id.tvTitle)
            tvTime = item.findViewById(R.id.tvTime)
        }

    }
}