package com.example.administrator.archdemo.di.animotion

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * @author Tiany
 * *
 * @desc
 * *
 * @date 2017/8/1 0001
 */
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
