package com.example.administrator.archdemo.base

/**
 * @desc
 * @author Tiany
 * @date 2017/8/7 0007
 */
class CommonResult<out NewsType>(val result: BaseNewsStatus<NewsType>) : BaseStatus() {

    override fun toString(): String {
        return "CommonResult(result=$result)"
    }
}