package com.michalkarmelita.catfacts.facts.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.michalkarmelita.catfacts.R
import com.michalkarmelita.catfacts.facts.model.CatFacts
import com.michalkarmelita.catfacts.facts.model.Fact

class CatFactsAdapter : RecyclerView.Adapter<FactViewHolder>(), Observer<CatFacts> {

    private val shareLiveData = MutableLiveData<String>()
    private var facts = mutableListOf<Fact>()

    override fun onChanged(data: CatFacts?) {
        if (data != null) {
            facts.addAll(data.data)
            notifyItemInserted(facts.size - data.data.size)
        }
    }


    override fun onBindViewHolder(holder: FactViewHolder?, position: Int) {
        holder?.bind(facts[position], shareLiveData)
    }

    override fun getItemCount(): Int = facts.size


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FactViewHolder =
            FactViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.cat_fact_item_view, parent, false))

    fun reset() {
        facts = mutableListOf()
        notifyDataSetChanged()
    }

    fun getShareLiveData() = shareLiveData
}

