package com.michalkarmelita.catfacts.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application) = application.applicationContext

}