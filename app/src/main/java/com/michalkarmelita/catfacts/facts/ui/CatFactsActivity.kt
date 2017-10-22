package com.michalkarmelita.catfacts.facts.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.michalkarmelita.catfacts.R
import dagger.android.AndroidInjection

class CatFactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
    }
}
