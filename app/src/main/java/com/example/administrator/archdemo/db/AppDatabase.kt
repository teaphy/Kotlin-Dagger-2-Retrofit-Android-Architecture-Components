
package com.example.administrator.archdemo.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.administrator.archdemo.db.dao.UserDao
import com.example.administrator.archdemo.entity.UserEntity

/**
 * @desc
 * 请注意:在Kotlin中，entities注解参数为vararg参数传递时，必须将参数的显示的的声明为arrayOf()
 * @author Teaphy
 * @date 2017/6/6
 */

@Database(entities = arrayOf(UserEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}