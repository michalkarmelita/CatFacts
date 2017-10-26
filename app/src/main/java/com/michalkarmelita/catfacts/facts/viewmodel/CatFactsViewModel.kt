package com.michalkarmelita.catfacts.facts.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.ViewModel
import com.michalkarmelita.catfacts.facts.model.CatFacts
import com.michalkarmelita.catfacts.facts.repository.CatFactsRepository

class CatFactsViewModel(val repository: CatFactsRepository) : ViewModel() {

    fun getCatFacts(): LiveData<CatFacts> {
        return LiveDataReactiveStreams.fromPublisher(repository.getCatFacts(100))
    }

}