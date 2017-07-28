package com.example.administrator.archdemo.viewmodel

import com.example.administrator.archdemo.bean.Dog
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * @desc
 * @author Tiany
 * @date 2017/7/28 0028
 */
@Singleton
class TestFactory @Inject
constructor() {

    @Inject
    lateinit var dogs: Map<String, Dog>

    fun provideDog(): Dog? {
        return dogs["A"]
    }
}