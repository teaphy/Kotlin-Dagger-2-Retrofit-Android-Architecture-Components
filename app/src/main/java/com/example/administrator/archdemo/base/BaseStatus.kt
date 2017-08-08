package com.example.administrator.archdemo.base

/**
 * @desc
 * @author Tiany
 * @date 2017/8/7 0007
 */
open class BaseStatus(var msg: String? = null,
                      var code: String? = null,
                      var charge: Boolean? = null) {


    override fun toString(): String {
        return "BaseStatus(msg=$msg, code=$code, charge=$charge)"
    }
}