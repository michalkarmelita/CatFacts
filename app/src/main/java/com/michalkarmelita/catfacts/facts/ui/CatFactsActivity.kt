package com.michalkarmelita.catfacts.facts.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.widget.SeekBar
import com.michalkarmelita.catfacts.R
import com.michalkarmelita.catfacts.common.BaseActivity
import com.michalkarmelita.catfacts.common.show
import com.michalkarmelita.catfacts.facts.viewmodel.CatFactsViewModel
import com.michalkarmelita.catfacts.facts.viewmodel.CatFactsViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_cat_facts.*
import javax.inject.Inject
import android.support.v4.app.ShareCompat



class CatFactsActivity : BaseActivity(), SeekBar.OnSeekBarChangeListener {

    @Inject
    lateinit var layoutManager: LinearLayoutManager
    @Inject
    lateinit var viewModelFactory: CatFactsViewModelFactory
    @Inject
    lateinit var adapter: CatFactsAdapter
    @Inject
    lateinit var snapHelper: PagerSnapHelper

    private lateinit var viewModel: CatFactsViewModel

    companion object {
        private val SHARE_TYPE = "plain/text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_facts)

        factsRecyclerView.layoutManager = layoutManager
        factsRecyclerView.adapter = adapter
        snapHelper.attachToRecyclerView(factsRecyclerView)

        factLengthSlider.setOnSeekBarChangeListener(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CatFactsViewModel::class.java)
        viewModel.getCatFacts().observe(this, adapter)
        viewModel.getMaxLength().observe(this, Observer { value -> factLengthValue.text = value.toString() })
        viewModel.getProgress().observe(this, Observer { progressVisibility -> progressbar.show(progressVisibility!!) })
        factLengthSlider.progress = viewModel.getMaxLengthValue()

        adapter.getShareLiveData().observe(this, Observer { text ->
            val intentBuilder = ShareCompat.IntentBuilder.from(this)
                    .setSubject(getString(R.string.fact_share_subject))
                    .setText(text)
                    .setType(SHARE_TYPE)
                    .setChooserTitle(R.string.share_chooser_title)

            startActivity(intentBuilder.createChooserIntent())
        })

    }

    override fun onProgressChanged(p0: SeekBar?, value: Int, p2: Boolean) {
        viewModel.setMaxLength(value)
        adapter.reset()
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }
}
