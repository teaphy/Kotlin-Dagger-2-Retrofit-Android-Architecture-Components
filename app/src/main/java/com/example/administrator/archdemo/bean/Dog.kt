package com.example.administrator.archdemo.bean

import javax.inject.Inject
import javax.inject.Singleton

/**
 * @desc
 * @author Tiany
 * @date 2017/7/27 0027
 */
@Singleton
class Dog @Inject constructor(){
    val id = 1
    val name = "wang"
    override fun toString(): String {
        return "Dog(id=$id, name='$name')"
    }


}