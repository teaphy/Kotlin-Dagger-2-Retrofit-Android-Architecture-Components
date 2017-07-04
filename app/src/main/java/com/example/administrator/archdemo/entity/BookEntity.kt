package com.example.administrator.archdemo.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @desc
 * @author Tiany
 * @date 2017/6/26 0026
 */
@Entity(tableName = "book")
data class BookEntity(var name: String,
                      var image: String,
                      var sortId: Int,
                      var brrowId: Boolean,
                      var brrowDate: Long){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    override fun toString(): String {
        return "BookEntity(name='$name', image='$image', sortId=$sortId, brrowId=$brrowId, brrowDate=$brrowDate, id=$id)"
    }
}