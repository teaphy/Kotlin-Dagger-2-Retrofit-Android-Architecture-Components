package com.example.administrator.archdemo.ui.lifecycle

import android.arch.lifecycle.*
import android.os.Bundle
import android.util.Log
import com.example.administrator.archdemo.R
import kotlinx.android.synthetic.main.activity_person.*
import org.jetbrains.anko.doAsync

class PersonActivity : LifecycleActivity(), LifecycleRegistryOwner {

    val mRegistry: LifecycleRegistry = LifecycleRegistry(this)

    val personObserver: PersonObserver = PersonObserver(mRegistry)

    val personLiveData: PersonLiveData = PersonLiveData()
    lateinit var personMapLiveData: LiveData<String>
    lateinit var personSwitchMapLiveData: LiveData<String>
    lateinit var mediaLiveData: MediatorLiveData<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)
        lifecycle.addObserver(personObserver)
        Log.i("tea", " onCreate")

        personLiveData.observe(this, Observer<Person?> {
            Log.d("tea", "id: ${it?.id} | name: ${it?.name}")
            tvValue.text = "id: ${it?.id} | name: ${it?.name}"
        })

        personMapLiveData = Transformations.map(personLiveData, {
            it: Person? ->

            it?.name
        })

        personMapLiveData.observe(this, Observer<String> {
            tvMap.text = it
        })

        personSwitchMapLiveData = Transformations.switchMap(personLiveData) {
            val result = MediatorLiveData<String>()
            it.name
            result.postValue(it.name)
            result
        }

        personSwitchMapLiveData.observe(this, Observer<String> {
            tvSwitchMap.text = it
        })

        mediaLiveData = MediatorLiveData()

        mediaLiveData.addSource(personLiveData, {
            newData ->
            Log.d("tea", "addSource")
            mediaLiveData.value = newData?.name
        })

        mediaLiveData.observe(this, Observer<String> {
            Log.d("tea", "observer")
            tvMedia.text = it
        })

        setListener()
    }

    private fun setListener() {
        btnSet.setOnClickListener {
            personLiveData.value = Person(1, "SetValue")
        }

        btnPost.setOnClickListener {
            doAsync {
                personLiveData.postValue(Person(1, "PostValue"))
            }
        }
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
        personLiveData.value = Person(3, "onStop")
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
