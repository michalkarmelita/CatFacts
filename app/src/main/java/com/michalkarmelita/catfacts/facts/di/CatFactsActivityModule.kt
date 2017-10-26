package com.michalkarmelita.catfacts.facts.di

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import com.michalkarmelita.catfacts.facts.ui.CatFactsActivity
import com.michalkarmelita.catfacts.facts.ui.CatFactsAdapter
import dagger.Module
import dagger.Provides


@Module
class CatFactsActivityModule {

    @Provides
    fun provideLayoutManager(activity: CatFactsActivity) = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

    @Provides
    fun provideRecyclerViewAdapter() = CatFactsAdapter()

    @Provides
    fun provideRecyclerViewSnapHelper() = PagerSnapHelper()
}