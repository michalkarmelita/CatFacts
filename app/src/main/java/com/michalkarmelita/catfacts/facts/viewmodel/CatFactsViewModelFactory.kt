package com.michalkarmelita.catfacts.facts.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.michalkarmelita.catfacts.facts.repository.CatFactsRepository
import javax.inject.Inject

class CatFactsViewModelFactory @Inject constructor(private val repository: CatFactsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CatFactsViewModel(repository) as T
    }

}

