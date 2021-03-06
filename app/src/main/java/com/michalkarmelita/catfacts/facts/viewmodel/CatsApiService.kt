package com.michalkarmelita.catfacts.facts.viewmodel

import com.michalkarmelita.catfacts.facts.model.api.CatFactApiResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface CatsApiService {

    @GET("/facts")
    fun getCatFacts(@Query("limit") itemsPerPage: Int,
                    @Query("max_length") length: Int): Flowable<CatFactApiResponse>

    @GET
    fun getCatFactsPage(@Url nextPage: String,
                        @Query("limit") itemsPerPage: Int,
                        @Query("max_length") length: Int): Flowable<CatFactApiResponse>

}