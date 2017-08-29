package com.example.administrator.archdemo.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.administrator.archdemo.entity.NewsEntity

/**
 * @desc
 * @author Tiany
 * @date 2017/8/7 0007
 */
@Dao
interface NewsDao {

    // 向表中插入一系列
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: List<NewsEntity>)

    @Query("SELECT * FROM news")
    fun queryAllNews(): LiveData<List<NewsEntity>>

    @Query("SELECT * FROM news")
    fun queryAllNewsForList(): List<NewsEntity>

    @Delete
    fun deleteAll(news: List<NewsEntity>)

}