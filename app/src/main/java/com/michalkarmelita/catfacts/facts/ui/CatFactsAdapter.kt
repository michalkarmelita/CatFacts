package com.michalkarmelita.catfacts.facts.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.michalkarmelita.catfacts.R
import com.michalkarmelita.catfacts.facts.model.CatFacts
import com.michalkarmelita.catfacts.facts.model.Fact

class CatFactsAdapter : RecyclerView.Adapter<FactViewHolder>() {

    var facts = mutableListOf<Fact>()

    override fun onBindViewHolder(holder: FactViewHolder?, position: Int) {
        holder?.bind(facts[position])
    }

    override fun getItemCount(): Int = facts.size


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FactViewHolder =
            FactViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.cat_fact_item_view, parent, false))

    fun addData(data: CatFacts) {
        facts.addAll(data.data)
        notifyDataSetChanged()
    }

}

