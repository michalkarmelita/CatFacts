package com.michalkarmelita.catfacts.facts.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.view.MotionEvent
import android.view.View
import android.widget.SeekBar
import com.michalkarmelita.catfacts.R
import com.michalkarmelita.catfacts.common.BaseActivity
import com.michalkarmelita.catfacts.facts.viewmodel.CatFactsViewModel
import com.michalkarmelita.catfacts.facts.viewmodel.CatFactsViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_cat_facts.*
import javax.inject.Inject

class CatFactsActivity : BaseActivity(), SeekBar.OnSeekBarChangeListener {

    @Inject
    lateinit var layoutManager: LinearLayoutManager
    @Inject
    lateinit var viewModelFactory: CatFactsViewModelFactory
    @Inject
    lateinit var adapter: CatFactsAdapter
    @Inject
    lateinit var snapHelper: PagerSnapHelper

    lateinit var viewModel: CatFactsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_facts)

        factsRecyclerView.layoutManager = layoutManager
        factsRecyclerView.adapter = adapter
        snapHelper.attachToRecyclerView(factsRecyclerView)

        factLengthSlider.setOnSeekBarChangeListener(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CatFactsViewModel::class.java)
        viewModel.getCatFacts().observe(this, Observer { facts -> adapter.addData(facts!!) })
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }
}
