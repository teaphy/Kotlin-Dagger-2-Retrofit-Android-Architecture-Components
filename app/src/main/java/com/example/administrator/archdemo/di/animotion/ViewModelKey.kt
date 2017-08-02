package com.example.administrator.archdemo.di.animotion

import android.arch.lifecycle.ViewModel

import java.lang.annotation.Documented
import java.lang.annotation.Retention

import dagger.MapKey

import java.lang.annotation.ElementType.METHOD
import java.lang.annotation.RetentionPolicy.RUNTIME
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
