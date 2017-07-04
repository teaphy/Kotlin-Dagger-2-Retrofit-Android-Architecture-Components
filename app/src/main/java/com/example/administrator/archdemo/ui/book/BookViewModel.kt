package com.example.administrator.archdemo.ui.book

import android.app.Application
import android.arch.core.util.Function
import android.arch.lifecycle.*
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import android.util.Log
import com.example.administrator.archdemo.db.AppDatabase
import com.example.administrator.archdemo.entity.BookEntity
import com.example.administrator.archdemo.util.AbsentLiveData
import org.jetbrains.anko.doAsync

/**
 * @desc
 * @author Tiany
 * @date 2017/6/26 0026
 */
class BookViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var bookId: MutableLiveData<Int>
    var bookEntity: LiveData<BookEntity>? = null
    lateinit var mDatabase: AppDatabase

    companion object {
        val ABS = MutableLiveData<BookEntity>()
    }

    init {
        ABS.value = null
        bookId = MutableLiveData()
    }

    fun init(database: AppDatabase) {
        this.mDatabase = database

        bookEntity = Transformations.switchMap(bookId, {

            val book = mDatabase.bookDao().queryBook_(it)
//            bookEntity.postValue(book)
            Log.i("123", "bookId: $it")
            Log.i("123", "book: $book")

            if (-1 == it) {
                AbsentLiveData.create<BookEntity>()
            } else {
                mDatabase.bookDao().queryBook(it)
            }
        })
    }

    fun getBook(): LiveData<BookEntity>? {
        return bookEntity
    }

    fun setBookId(id: Int) {
        bookId.postValue(id)
    }

    fun insertBook() {
        doAsync {

            mDatabase.beginTransaction()

            val english = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498559024821&di=05fb9bf4ba83bbe1ebe62cc4611e5ca1&imgtype=0&src=http%3A%2F%2Fwww.mnw.cn%2Fattachments%2F2014%2F03%2F17%2F599150_201403170944021DNd4.jpg"
            val chinese = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1499153802&di=add0df9107f3e6578e61089efcab9e6d&imgtype=jpg&er=1&src=http%3A%2F%2Fpic.baike.soso.com%2Fp%2F20130929%2F20130929085254-213184244.jpg"

            val books = mutableListOf<BookEntity>()
            books.add(BookEntity("英语", english, 1, false, System.currentTimeMillis()))
            books.add(BookEntity("语文", chinese, 2, true, System.currentTimeMillis()))
            books.add(BookEntity("英语", english, 1, true, System.currentTimeMillis()))
            books.add(BookEntity("语文", chinese, 2, false, System.currentTimeMillis()))

            try {
                val ins = mDatabase.bookDao().insertBook(books)
                Log.i("123", "ins: $ins")
                mDatabase.setTransactionSuccessful()
            } finally {
                mDatabase.endTransaction()
            }
        }
    }


    fun updateBook() {

        doAsync {
            mDatabase.beginTransaction()
            try {
                val english = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498559024821&di=05fb9bf4ba83bbe1ebe62cc4611e5ca1&imgtype=0&src=http%3A%2F%2Fwww.mnw.cn%2Fattachments%2F2014%2F03%2F17%2F599150_201403170944021DNd4.jpg"

                val book = BookEntity("英语", english, 1, true, System.currentTimeMillis())
                book.id = 1
                mDatabase.bookDao().updateBook(book)
                mDatabase.setTransactionSuccessful()
            } finally {
                mDatabase.endTransaction()
            }
        }

    }

    fun queryBook() {
        mDatabase.beginTransaction()
        try {

            val books = mDatabase.bookDao().queryBook()
            Log.i("123", "books: $books")
            mDatabase.setTransactionSuccessful()
        } finally {
            mDatabase.endTransaction()
        }
    }
}