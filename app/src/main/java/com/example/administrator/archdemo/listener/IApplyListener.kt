package com.example.administrator.archdemo.listener

/**
 * @desc
 * @author Tiany
 * @date 2017/8/29 0029
 */
interface IApplyListener<in T> {
    fun apply(t: T)
}