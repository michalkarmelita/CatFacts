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
    private val progress = MutableLiveData<Boolean>()

    init {
        progress.postValue(true)
        limit.value = initialMaxLength
        results = Transformations.switchMap(limit, { limit ->
            LiveDataReactiveStreams.fromPublisher(repository.getCatFacts(limit)
                    .doAfterNext { progress.postValue(false) })
        })
    }

    fun setMaxLength(newLimit: Int) {
        limit.postValue(newLimit * lengthStep)
        progress.postValue(true)
    }

    fun getCatFacts(): LiveData<CatFacts> = results

    fun getMaxLengthValue(): Int = limit.value!!

    fun getMaxLength(): LiveData<Int> = limit

    fun getProgress(): LiveData<Boolean> = progress
}