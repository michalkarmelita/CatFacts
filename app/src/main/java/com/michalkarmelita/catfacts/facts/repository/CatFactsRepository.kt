package com.michalkarmelita.catfacts.facts.repository

import com.michalkarmelita.catfacts.facts.model.CatFacts
import com.michalkarmelita.catfacts.facts.viewmodel.CatsApiService
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CatFactsRepository @Inject constructor(val api: CatsApiService) {

    companion object {
        val itemsPerPage = 100
    }

    fun getCatFacts(limit: Int): Flowable<CatFacts> {
        return api.getCatFacts(limit, itemsPerPage)
                .subscribeOn(Schedulers.io())
                .map(Mapper().map())
                .observeOn(AndroidSchedulers.mainThread())
    }

}

