package com.michalkarmelita.catfacts.facts.viewmodel

import com.michalkarmelita.catfacts.facts.model.api.CatFactApiResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface CatsApiService {

    @GET("/facts")
    fun getCatFacts(@Query("limit") limit: Int,
                    @Query("max_length") maxLength: Int): Flowable<CatFactApiResponse>

    @GET
    fun getCatFactsPage(@Query("limit") limit: Int,
                        @Query("max_length") maxLength: Int,
                        @Query("page") page: Int): Flowable<CatFactApiResponse>

}