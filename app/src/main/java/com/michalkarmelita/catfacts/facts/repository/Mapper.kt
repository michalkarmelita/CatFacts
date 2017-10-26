package com.michalkarmelita.catfacts.facts.repository

import com.michalkarmelita.catfacts.facts.model.CatFacts
import com.michalkarmelita.catfacts.facts.model.Fact
import com.michalkarmelita.catfacts.facts.model.api.CatFactApiResponse
import io.reactivex.functions.Function

class Mapper {

    fun map(): Function<CatFactApiResponse, CatFacts> {
        return Function { (total, _, current_page, last_page, _, _, _, _, data) ->
            val facts = data.map { Fact(it.fact) }
            CatFacts(total, current_page, last_page, facts)
        }
    }

}