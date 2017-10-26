package com.michalkarmelita.catfacts.common

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), LifecycleOwner {

    private val mRegistry = LifecycleRegistry(this)

    override fun getLifecycle() = mRegistry

}