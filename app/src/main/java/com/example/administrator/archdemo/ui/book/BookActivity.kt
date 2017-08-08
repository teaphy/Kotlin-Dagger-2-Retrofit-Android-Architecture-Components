package com.example.administrator.archdemo.ui.book

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.persistence.room.Room
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.api.ArchService
import com.example.administrator.archdemo.base.BaseToolbarActivity
import com.example.administrator.archdemo.db.AppDatabase
import com.example.administrator.archdemo.db.AppDatabase.Companion.DATABASE_NAME
import com.example.administrator.archdemo.entity.BookEntity
import com.example.administrator.archdemo.entity.UserEntity
import com.example.administrator.archdemo.global.UrlObject
import kotlinx.android.synthetic.main.activity_book.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BookActivity : BaseToolbarActivity() {

    lateinit var mViewModel: BookViewModel
    var mBookId: Int = 1

    lateinit var mDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel.getBook()?.observe(this, Observer<BookEntity> {
            tvBook.text = it.toString()
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_book
    }

    override fun initTitle(): CharSequence? {
        return "书"
    }

    override fun initData() {
        applicationContext.deleteDatabase(DATABASE_NAME)
        mDatabase = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()


        mViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        mViewModel.init(mDatabase)
    }

    override fun initView() {

    }

    override fun setListener() {

        acbGithub.setOnClickListener {
            val retrofit : Retrofit = Retrofit.Builder()
                    .baseUrl(UrlObject.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            val archService: ArchService = retrofit.create(ArchService::class.java)

        }

        btnInsert.setOnClickListener {
            mViewModel.insertBook()
        }

        btnUpdate.setOnClickListener {
            mViewModel.updateBook()
        }

        btnSearch.setOnClickListener {
            val id = editId.text.toString()
            if (!TextUtils.isEmpty(id)) {
                Toast.makeText(application, "id: $id", Toast.LENGTH_SHORT).show()
                mViewModel.setBookId(id.toInt())
            }
        }

        btnQueryAll.setOnClickListener {
            mViewModel.queryBook()
        }
    }
}
