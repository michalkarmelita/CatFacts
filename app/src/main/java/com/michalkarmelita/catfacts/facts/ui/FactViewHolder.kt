package com.michalkarmelita.catfacts.facts.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import com.michalkarmelita.catfacts.facts.model.Fact
import kotlinx.android.synthetic.main.cat_fact_item_view.view.*

class FactViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    fun bind(fact: Fact) {
        itemView.fact_text.text = fact.factText
    }

}

