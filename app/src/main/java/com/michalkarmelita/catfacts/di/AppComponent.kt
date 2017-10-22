package com.michalkarmelita.catfacts.di

import android.app.Application
import com.michalkarmelita.catfacts.CatFactsApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule


@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: CatFactsApp)
}