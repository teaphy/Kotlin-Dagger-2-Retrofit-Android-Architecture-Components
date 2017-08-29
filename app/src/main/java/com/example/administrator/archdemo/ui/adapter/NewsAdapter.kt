package com.example.administrator.archdemo.ui.adapter

import android.content.Context
import android.opengl.Visibility
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.entity.NewsEntity
import com.example.administrator.archdemo.listener.IApplyListener

/**
 * @desc This is for display the news
 * @author Tiany
 * @date 2017/8/9 0009
 */
class NewsAdapter(var list: MutableList<NewsEntity>, val context: Context, newsType: String) : RecyclerView.Adapter<NewsAdapter.MyHolder>() {

    var applyListener: IApplyListener<NewsEntity>? = null
    private var isCollect: Boolean

    init {
        if (null == list) {
            list = mutableListOf()
        }

        isCollect = TextUtils.equals("收藏", newsType)
    }

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

        if (isCollect) {
            holder?.cbCollection!!.visibility = View.GONE
        } else {
            holder?.cbCollection!!.visibility = View.VISIBLE
            holder.cbCollection.isChecked = news.isCollected
            holder.cbCollection.setOnCheckedChangeListener { _, isChecked ->
                news.isCollected = isChecked
                applyListener?.apply(news)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false)

        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun getItem(position: Int): NewsEntity {
        return list[position]
    }

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        val ivNews: ImageView = item.findViewById(R.id.ivNews)
        val tvTitle: TextView = item.findViewById(R.id.tvTitle)
        val tvTime: TextView = item.findViewById(R.id.tvTime)
        val cbCollection: CheckBox = item.findViewById(R.id.cbCollection)

    }
}