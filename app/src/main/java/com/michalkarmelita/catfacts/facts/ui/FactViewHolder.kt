package com.michalkarmelita.catfacts.facts.ui

import android.arch.lifecycle.MutableLiveData
import android.support.v7.widget.RecyclerView
import android.view.View
import com.michalkarmelita.catfacts.R
import com.michalkarmelita.catfacts.facts.model.Fact
import kotlinx.android.synthetic.main.cat_fact_item_view.view.*
import java.util.*

class FactViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    fun bind(fact: Fact, shareLiveData: MutableLiveData<String>) {
        itemView.fact_text.text = fact.factText
        itemView.fact_share.setOnClickListener({ shareLiveData.postValue(fact.factText) })
        itemView.fact_bg.setImageResource(getRandomCat())
    }

    private fun getRandomCat() : Int {
        val random = Random()
        val catrandom = random.nextInt(4)
        var catImage = 0
        when (catrandom) {
            1 -> catImage = R.drawable.cat_1
            2 -> catImage = R.drawable.cat_2
            3 -> catImage = R.drawable.cat_3
            4 -> catImage = R.drawable.cat_4
            0 -> catImage = R.drawable.cat_5
        }
        return catImage
    }
}

