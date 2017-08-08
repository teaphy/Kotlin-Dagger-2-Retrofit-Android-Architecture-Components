package com.example.administrator.archdemo.base

/**
 * @desc
 * @author Tiany
<017/8/7 0007
 */
class BaseNewsResult<out NewsType>(val num: Int, val channel: String, val list: List<NewsType>) {
    override fun toString(): String {
        return "BaseNewsResult(num=$num, channel='$channel', list=$list)"
    }
}