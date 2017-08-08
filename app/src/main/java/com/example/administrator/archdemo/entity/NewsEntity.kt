package com.example.administrator.archdemo.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "news",
        indices = arrayOf(Index(*arrayOf("url"), unique = true)))
data class NewsEntity(
        var src: String, // 新闻来源
        var weburl: String, // 新闻Url
        var time: String, // 时间
        var pic: String, // 新闻图片
        var title: String, // 新闻标题
        var category: String, // 新闻类别
        var url: String, //  新闻Url
        var content: String // 新闻内容
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    // 新闻类型
    var newsType: Int = 1

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val repo = o as NewsEntity?

        return url == repo!!.url
    }

    override fun hashCode(): Int {
        return url.hashCode()
    }

    override fun toString(): String {
        return "NewsEntity(src='$src', weburl='$weburl', time='$time', pic='$pic', title='$title', category='$category', url='$url', content='$content', id=$id, newsType=$newsType)"
    }


}
