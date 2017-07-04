package com.example.administrator.archdemo.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey


/**
 * @desc
 * 在Kotlin中，如果主构造函数有注解或可见性声明，则constructor关键字是不可少的
 * @author Teaphy
 * @date 2017/6/6
 */
//@Entity(tableName = "user")
//data class UserEntity ( @ColumnInfo(name = "name")val name: String,
//                                  @ColumnInfo(name = "is_brrowed")val isBrrowed: Int) {
//    @JvmField
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
//    var id: Int = 0
//}

@Entity(tableName = "user", indices = arrayOf(Index(value = *arrayOf("name", "isBrrowed"), unique = true)))
data class UserEntity(val name: String, val isBrrowed: Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}