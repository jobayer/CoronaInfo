package com.jobayer.coronainfo.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jobayer.coronainfo.R
import com.jobayer.coronainfo.adapter.OSLItemAdapter
import com.jobayer.coronainfo.model.License
import kotlinx.android.synthetic.main.activity_license.*

class LicenseActivity : AppCompatActivity() {

    private lateinit var licenseList: ArrayList<License>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_license)
        init()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun init() {
        initToolbar()
        initLicense()
        initRecyclerView()
    }

    private fun initToolbar() {
        supportActionBar?.title = "ওপেন সোর্স লাইসেন্স"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(resources.getDrawable(R.drawable.icon_back, theme))
    }

    private fun initLicense() {
        licenseList = ArrayList()
        licenseList.add(License(1, "AndroidX Preference"))
        licenseList.add(License(2, "Retrofit"))
        licenseList.add(License(3, "Paper"))
        licenseList.add(License(4, "Firebase"))
        licenseList.add(License(5, "GitHub Icon"))
        licenseList.add(License(6, "App Icon"))
        licenseList.add(License(7, "API License"))
        licenseList.sortWith(Comparator { o1, o2 ->
            o1?.name!!.compareTo(
                o2?.name!!,
                ignoreCase = true
            )
        })
    }

    private fun initRecyclerView() {
        oslRecyclerView.layoutManager = LinearLayoutManager(this)
        oslRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        oslRecyclerView.adapter = OSLItemAdapter(this, licenseList)
    }

}
