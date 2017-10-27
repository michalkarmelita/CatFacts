package com.michalkarmelita.catfacts.facts.repository

import com.michalkarmelita.catfacts.facts.model.CatFacts
import com.michalkarmelita.catfacts.facts.viewmodel.CatsApiService
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CatFactsRepository @Inject constructor(private val api: CatsApiService) {

    companion object {
        val itemsPerPage = 10
    }

    fun getCatFacts(maxLength: Int): Flowable<CatFacts> {
        return api.getCatFacts(itemsPerPage, maxLength)
                .subscribeOn(Schedulers.io())
                .map(Mapper().map())
                .observeOn(AndroidSchedulers.mainThread())
    }

}

