package com.example.administrator.archdemo.base

/**
 * @desc
 * @author Tiany
 * @date 2017/8/7 0007
 */
class BaseNewsStatus<out NewsType>(val msg: String,
                                   val status: Int,
                                   val result: BaseNewsResult<NewsType>) {
    override fun toString(): String {
        return "BaseNewsStatus(msg='$msg', status=$status, result=$result)"
    }
}