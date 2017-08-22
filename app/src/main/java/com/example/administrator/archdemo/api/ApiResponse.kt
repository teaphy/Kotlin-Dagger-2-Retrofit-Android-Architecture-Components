package com.example.administrator.archdemo.api

import com.example.administrator.archdemo.enum.ResponseEnum

/**
 * @desc
 * @author Tiany
 * @date 2017/8/22 0022
 */
data class ApiResponse<out T>(val body: T?, val responseEnum: ResponseEnum, val message: String?)