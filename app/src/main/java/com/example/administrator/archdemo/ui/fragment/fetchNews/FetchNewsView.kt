package com.example.administrator.archdemo.ui.fragment.fetchNews

/**
 * @desc
 * @author Tiany
 * @date 2017/8/22 0022
 */
interface FetchNewsView {

    fun provideChannel(): String

    fun fetchNewsFailure()

}