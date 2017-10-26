package com.michalkarmelita.catfacts.facts.model.api


data class CatFactApiResponse(
		val total: Int, //166
		val per_page: String, //100
		val current_page: Int, //1
		val last_page: Int, //2
		val next_page_url: Any, //https://catfact.ninja/facts?page=2
		val prev_page_url: String, //null
		val from: Int, //1
		val to: Int, //100
		val data: List<Data>
)

data class Data(
		val fact: String, //Statistics indicate that animal lovers in recent years have shown a preference for cats over dogs!
		val length: Int //98
)