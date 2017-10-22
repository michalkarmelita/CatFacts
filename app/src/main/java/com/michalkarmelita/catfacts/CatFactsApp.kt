package com.michalkarmelita.catfacts

import android.app.Activity
import android.app.Application
import com.michalkarmelita.catfacts.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class CatFactsApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)

    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> = activityAndroidInjector

}