package com.example.administrator.archdemo.ui.lifecycle

import android.arch.lifecycle.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.administrator.archdemo.R

class PersonActivity : LifecycleActivity(), LifecycleRegistryOwner {

    val mRegistry: LifecycleRegistry = LifecycleRegistry(this)

    val personObserver: PersonObserver = PersonObserver(mRegistry)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)
        lifecycle.addObserver(personObserver)
        Log.i("tea", " onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("tea", " onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("tea", " onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("tea", " onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("tea", " onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("tea", " onDestroy")
    }

    override fun getLifecycle(): LifecycleRegistry {
        return mRegistry
    }
}
