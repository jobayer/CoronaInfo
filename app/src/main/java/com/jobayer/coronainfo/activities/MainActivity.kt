package com.jobayer.coronainfo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jobayer.coronainfo.R
import com.jobayer.coronainfo.adapter.DistrictListAdapter
import com.jobayer.coronainfo.model.District
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var districtList: ArrayList<District>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        districtList = ArrayList()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DistrictListAdapter(this, districtList)
    }

    private fun getUpdate() {

    }

}
