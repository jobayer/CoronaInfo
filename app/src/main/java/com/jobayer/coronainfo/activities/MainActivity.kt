package com.jobayer.coronainfo.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.analytics.FirebaseAnalytics
import com.jobayer.coronainfo.R
import com.jobayer.coronainfo.adapter.DistrictListAdapter
import com.jobayer.coronainfo.api.CoronaInfoAPI
import com.jobayer.coronainfo.extensions.*
import com.jobayer.coronainfo.model.District
import com.jobayer.coronainfo.model.Districts
import com.jobayer.coronainfo.model.Stats
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private lateinit var districtList: ArrayList<District>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_item_info) startActivity(
            Intent(
                this,
                AboutActivity::class.java
            )
        )
        return super.onOptionsItemSelected(item)
    }

    private fun init() {
        initRecyclerView()
        update(false)
        initStats()
        initDistricts()
        initOnClick()
        checkFirstRun()
    }

    private fun initRecyclerView() {
        districtList = ArrayList()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DistrictListAdapter(this, districtList)
    }

    private fun initOnClick() {
        updateButton.setOnClickListener {
            update(true)
        }
        moreInfoButton.setOnClickListener {
            startActivity(Intent(this, MoreInfoActivity::class.java))
        }
        helpCenterButton.setOnClickListener {
            startActivity(Intent(this, HelpCenterActivity::class.java))
        }
    }

    private fun initStats() {
        val stats = get("stats") as Stats?
        stats?.let {
            lastUpdateTime.text = it.lastUpdate.toBangla()
            newSampleCollectionCounter.text = it.last.tested.toString().toBangla()
            newAffectedCounter.text = it.last.confirmed.toString().toBangla()
            newRecoveredCounter.text = it.last.recovered.toString().toBangla()
            newDeathCounter.text = it.last.deaths.toString().toBangla()

        }
    }

    private fun initDistricts() {
        val districts = get("districts") as Districts?
        districts?.let {
            districtList.clear()
            districtList.addAll(it.data)
            recyclerView.adapter?.notifyDataSetChanged()
            recyclerView.invalidate()
        }
    }

    private fun update(manualUpdate: Boolean) {
        val currentTime = System.currentTimeMillis()
        val coronaInfoInterface = retrofit().create(CoronaInfoAPI::class.java)
        coronaInfoInterface.getStats().enqueue(object : Callback<Stats> {
            override fun onFailure(call: Call<Stats>, t: Throwable) {
                Toast.makeText(this@MainActivity, "তথ্য হালনাগাদ বিফল", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(call: Call<Stats>, response: Response<Stats>) {
                if (response.isSuccessful) {
                    val stats = response.body()
                    stats?.let {
                        write("stats", stats)
                        write("lastStatsUpdateTime", currentTime)
                        initStats()
                        if (manualUpdate) {
                            Toast.makeText(
                                this@MainActivity,
                                "তথ্য সফলভাবে হালনাগাদ হয়েছে",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                } else {
                    Toast.makeText(this@MainActivity, "তথ্য হালনাগাদ বিফল", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
        coronaInfoInterface.getDistricts().enqueue(object : Callback<Districts> {
            override fun onFailure(call: Call<Districts>, t: Throwable) {
                Toast.makeText(this@MainActivity, "তথ্য হালনাগাদ বিফল", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(call: Call<Districts>, response: Response<Districts>) {
                if (response.isSuccessful) {
                    val districts = response.body()
                    districts?.let {
                        write("districts", districts)
                        write("lastDistrictsUpdateTime", currentTime)
                        initDistricts()
                        if (manualUpdate) {
                            Toast.makeText(
                                this@MainActivity,
                                "তথ্য সফলভাবে হালনাগাদ হয়েছে",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                } else {
                    Toast.makeText(this@MainActivity, "তথ্য হালনাগাদ বিফল", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    private fun checkFirstRun() {
        if (isFirstRun()) {
            AlertDialog.Builder(this)
                .setMessage("প্রতিটি জেলার উপর ক্লিক করলে ওই জেলার বিস্তারিত তথ্য দেখতে পারবেন")
                .setPositiveButton(
                    "ধন্যবাদ"
                ) { _, _ ->
                    initFirstRun()
                }
                .show()
        }
    }

}
