
package com.example.administrator.archdemo.db.dao

import android.arch.persistence.room.*
import com.example.administrator.archdemo.entity.UserEntity

/**
 * @desc
 * @author Teaphy
 * @date 2017/6/6
 */
@Dao
interface UserDao {
    // 向表中插入一系列
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(users: List<UserEntity>)

    // 更新表中一系列数据
    @Update
    fun updateUser(vararg user: UserEntity): Int

    @Update
    fun updateUser(users: List<UserEntity>): Int

    // 删除表中的数据
    @Delete
    fun deleteUser(vararg user: UserEntity): Int

    @Delete
    fun deleteUser(users: List<UserEntity>): Int

    // 查询数据
    @Query("SELECT * FROM user")
    fun queryAll(): List<UserEntity>?
}