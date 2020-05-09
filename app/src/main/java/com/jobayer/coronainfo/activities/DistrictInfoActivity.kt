package com.jobayer.coronainfo.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.jobayer.coronainfo.R
import com.jobayer.coronainfo.extensions.toBangla
import com.jobayer.coronainfo.model.District
import kotlinx.android.synthetic.main.activity_district_info.*

class DistrictInfoActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_district_info)
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        initData()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {
        val district = intent.getParcelableExtra<District>("selectedDistrict")
        district?.let {
            initToolbar(it.bnname)
            districtTotalRecovered.text = it.recovered.toString().toBangla()
            districtTotalAffected.text = it.confirmed.toString().toBangla()
            districtTotalDeath.text = it.deaths.toString().toBangla()
        }
    }

    private fun initToolbar(districtName: String) {
        supportActionBar?.title = districtName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(resources.getDrawable(R.drawable.icon_back, theme))
    }

}
