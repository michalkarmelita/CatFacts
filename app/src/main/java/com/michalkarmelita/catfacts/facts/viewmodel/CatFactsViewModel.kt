package com.michalkarmelita.catfacts.facts.viewmodel

import android.arch.lifecycle.*
import com.michalkarmelita.catfacts.facts.model.CatFacts
import com.michalkarmelita.catfacts.facts.repository.CatFactsRepository


class CatFactsViewModel(private val repository: CatFactsRepository) : ViewModel() {

    companion object {
        val initialMaxLength = 20
        val lengthStep = 10
    }

    private val limit = MutableLiveData<Int>()
    private var results: LiveData<CatFacts>

    init {
        limit.value = initialMaxLength
        results = Transformations.switchMap(limit, { limit ->
            LiveDataReactiveStreams.fromPublisher(repository.getCatFacts(limit)) })
    }


    fun setMaxLength(newLimit: Int) {
        limit.postValue(newLimit * lengthStep)
    }

    fun getCatFacts(): LiveData<CatFacts> {
        return results
    }

    fun getMaxLength(): Int {
        return limit.value!!
    }
}