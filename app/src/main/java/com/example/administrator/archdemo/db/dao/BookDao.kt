package com.example.administrator.archdemo.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.administrator.archdemo.entity.BookEntity

/**
 * @desc
 * @author Tiany
 * @date 2017/6/27 0027
 */
@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(lists: List<BookEntity>): List<Long>

    @Update
    fun updateBook(entity: BookEntity)

    @Query("SELECT * FROM book where id = :id")
    fun queryBook(id: Int): LiveData<BookEntity>

    @Query("SELECT * FROM book where id = :id")
    fun queryBook_(id: Int): BookEntity

    @Query("SELECT * FROM book")
    fun queryBook(): List<BookEntity>
}