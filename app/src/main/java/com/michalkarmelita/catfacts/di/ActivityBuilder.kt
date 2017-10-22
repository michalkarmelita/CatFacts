package com.michalkarmelita.catfacts.di

import com.michalkarmelita.catfacts.facts.di.CatFactsActivityModule
import com.michalkarmelita.catfacts.facts.ui.CatFactsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = arrayOf(CatFactsActivityModule::class))
    abstract fun bindCatFactsActivity(): CatFactsActivity

}