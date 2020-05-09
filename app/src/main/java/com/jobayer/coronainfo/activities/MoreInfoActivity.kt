package com.jobayer.coronainfo.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.jobayer.coronainfo.R
import com.jobayer.coronainfo.extensions.toBangla
import com.jobayer.coronainfo.model.Stats
import kotlinx.android.synthetic.main.activity_more_info.*

class MoreInfoActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        init()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun init() {
        initToolbar()
        initData()
    }

    private fun initToolbar() {
        supportActionBar?.title = "আরো তথ্য"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(resources.getDrawable(R.drawable.icon_back, theme))
    }

    private fun initData() {
        val stats = com.jobayer.coronainfo.extensions.get("stats") as Stats?
        stats?.let {
            totalSampleCollectionCounter.text = stats.total.tested.toString().toBangla()
            totalAffectedCounter.text = stats.total.confirmed.toString().toBangla()
            totalRecoveredCounter.text = stats.total.recovered.toString().toBangla()
            totalDeathCounter.text = stats.total.deaths.toString().toBangla()
        }
    }

}
