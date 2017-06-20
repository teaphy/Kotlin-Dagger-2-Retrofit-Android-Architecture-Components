package com.example.administrator.archdemo.ui.activity

import android.annotation.SuppressLint
import android.arch.persistence.room.InvalidationTracker
import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.webkit.WebViewClient
import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.base.BaseActivity
import com.example.administrator.archdemo.db.AppDatabase
import com.example.administrator.archdemo.entity.UserEntity
import com.example.administrator.archdemo.ui.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_room.*
import org.jetbrains.anko.*

/**
 * @desc  Room
 * @author Teaphy
 * @date 2017/6/6
 */
class RoomActivity : BaseActivity(), AnkoLogger {

    val DATABASE_NAME = "test"

    lateinit var mDataBase: AppDatabase

    var id: Int = 1
    val mList: MutableList<UserEntity> = mutableListOf()
    val mAdapterUser = UserAdapter(mList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_room
    }

    override fun initTitle(): CharSequence? {
        return getString(R.string.room)
    }

    override fun initData() {
    }

    override fun initView() {
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_book.layoutManager = manager
        rv_book.adapter = mAdapterUser
    }

    @SuppressLint("StaticFieldLeak")
    override fun setListener() {
        acb_create.setOnClickListener {

            doAsync {
                applicationContext.deleteDatabase(DATABASE_NAME)
                mDataBase = Room.databaseBuilder(applicationContext,
                        AppDatabase::class.java, DATABASE_NAME)
                        .allowMainThreadQueries()
                        .build()
            }
        }

        acb_insert.setOnClickListener {
            doAsync {
                val users: MutableList<UserEntity> = mutableListOf()

                (0..10).mapTo(users) {
                    val user = UserEntity( "Test - $it", it)
                    id++
                    user
                }

                mDataBase?.beginTransaction()

                try {
                    mDataBase?.userDao()?.insertUser(users)
                    mDataBase?.setTransactionSuccessful()
                } finally {
                    mDataBase?.endTransaction()
                }
            }
        }

        acb_update.setOnClickListener {
            doAsync {
                val users: MutableList<UserEntity> = mutableListOf()

                id = 1

                (1..2).mapTo(users) {
                    val user = UserEntity("update - $it", it)
                    user.id = it
                    user
                }

                mDataBase?.beginTransaction()

                try {
                    val update = mDataBase?.userDao()?.updateUser(users)
                    Log.d("123", "update:$update")
                    mDataBase?.setTransactionSuccessful()
                } finally {
                    mDataBase?.endTransaction()
                }
            }
        }

        acb_delete.setOnClickListener {
            doAsync {
                val users: MutableList<UserEntity> = mutableListOf()

                id = 1

                (1..10).mapTo(users) {
                    val user = UserEntity("Test - $it", it)
                    user.id = it
                    user
                }

                mDataBase?.beginTransaction()

                try {
                    val del = mDataBase?.userDao()?.deleteUser(users)
                    Log.d("123", "del: $del")
                    mDataBase?.setTransactionSuccessful()
                } finally {
                    mDataBase?.endTransaction()
                }
            }
        }

        acb_query.setOnClickListener {
            var users: List<UserEntity>? = null
            doAsync {
                mDataBase?.beginTransaction()

                try {
                    users = mDataBase?.userDao()?.queryAll()
                    Log.i("123", users?.toString())
                    mDataBase?.setTransactionSuccessful()
                } finally {
                    mDataBase?.endTransaction()
                }

                runOnUiThread {
                    mList.clear()
                    mList.addAll(mList.size, users!!.toList())
                    mAdapterUser.notifyDataSetChanged()
                }
            }


        }
    }

    fun showToast(content: String) {
        toast(content)
    }
}
