package com.jobayer.coronainfo.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.jobayer.coronainfo.R
import com.jobayer.coronainfo.activities.DistrictInfoActivity
import com.jobayer.coronainfo.extensions.toBangla
import com.jobayer.coronainfo.model.District
import kotlinx.android.synthetic.main.district_item.view.*

class DistrictListAdapter(private val activity: Activity, private val districtList: ArrayList<District>) :
    RecyclerView.Adapter<DistrictListAdapter.DistrictListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DistrictListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.district_item, parent, false)
        )

    override fun getItemCount(): Int {
        return districtList.size
    }

    override fun onBindViewHolder(holder: DistrictListViewHolder, position: Int) {
        holder.bindView(activity, position, districtList[position])
    }

    class DistrictListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val rootView: RelativeLayout = view.container
        private val name: AppCompatTextView = view.name
        private val number: AppCompatTextView = view.count

        fun bindView(activity: Activity, position: Int, district: District) {
            name.text = district.bnname
            number.text = district.confirmed.toString().toBangla()
            if (position % 2 == 0) {
                rootView.setBackgroundColor(
                    ResourcesCompat.getColor(
                        activity.resources,
                        R.color.grayLineColor,
                        activity.theme
                    )
                )
            } else {
                rootView.setBackgroundColor(
                    ResourcesCompat.getColor(
                        activity.resources,
                        R.color.white,
                        activity.theme
                    )
                )
            }
            rootView.setOnClickListener {
                val districtInfoIntent = Intent(activity, DistrictInfoActivity::class.java)
                districtInfoIntent.putExtra("selectedDistrict", district)
                activity.startActivity(districtInfoIntent)
            }
        }
    }

}