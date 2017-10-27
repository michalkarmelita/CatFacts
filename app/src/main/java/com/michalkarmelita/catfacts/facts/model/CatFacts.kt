package com.michalkarmelita.catfacts.facts.model

data class CatFacts(val total: Int, //166
                    val current_page: Int, //1
                    val last_page: Int, //2
                    val nextPage: String?,
                    val data: List<Fact>
)

data class Fact(val factText: String)