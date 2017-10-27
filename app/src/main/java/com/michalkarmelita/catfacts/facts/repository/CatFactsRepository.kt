package com.michalkarmelita.catfacts.facts.repository

import com.michalkarmelita.catfacts.facts.model.CatFacts
import com.michalkarmelita.catfacts.facts.viewmodel.CatsApiService
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class CatFactsRepository @Inject constructor(private val api: CatsApiService) {

    companion object {
        val itemsPerPage = 50
    }

    fun getCatFacts(maxLength: Int): Flowable<CatFacts> {
        return getFirstPage(maxLength)
    }

    private fun getFirstPage(maxLength: Int): Flowable<CatFacts> {
        return api.getCatFacts(itemsPerPage, maxLength)
                .subscribeOn(Schedulers.io())
                .map(Mapper().map())
                .flatMap({ catFacts -> getNextPage(maxLength, catFacts) })
    }

    private fun getPage(page: String, maxLength: Int): Flowable<CatFacts> {
        return api.getCatFactsPage(page, itemsPerPage, maxLength)
                .subscribeOn(Schedulers.io())
                .map(Mapper().map())
                .flatMap({ catFacts -> getNextPage(maxLength, catFacts) })
                .filter({ catFacts -> !isLastPage(catFacts) })
    }

    private fun getNextPage(maxLength: Int, catFacts: CatFacts): Flowable<CatFacts> {
        val usersPageObservable = Flowable.just(catFacts)
        val nextPage = catFacts.nextPage
        val nextUsersPageObservable = getPage(nextPage!!, maxLength)
        return Flowable.merge(nextUsersPageObservable, usersPageObservable)
    }

    private fun isLastPage(catFacts: CatFacts): Boolean {
        return catFacts.nextPage == null
    }

}

