package com.jobayer.coronainfo.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.jobayer.coronainfo.R
import com.jobayer.coronainfo.activities.LicenseDetailsActivity
import com.jobayer.coronainfo.extensions.openUrl
import com.jobayer.coronainfo.model.License
import kotlinx.android.synthetic.main.osl_item_layout.view.*

class OSLItemAdapter(private val activity: Activity, private val licenseList: ArrayList<License>) :
    RecyclerView.Adapter<OSLItemAdapter.OSLListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        OSLListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.osl_item_layout, parent, false)
        )

    override fun getItemCount(): Int {
        return licenseList.size
    }

    override fun onBindViewHolder(holder: OSLListViewHolder, position: Int) {
        holder.bindView(activity, licenseList[position])
    }

    class OSLListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val rootView: LinearLayout = view.oslItemRootView
        private val name: AppCompatTextView = view.licenseName

        fun bindView(activity: Activity, license: License) {
            name.text = license.name
            rootView.setOnClickListener {
                if (license.id == 7) {
                    activity.openUrl("https://corona.in.com.bd/api/license")
                } else {
                    val licenseDetailsIntent = Intent(activity, LicenseDetailsActivity::class.java)
                    licenseDetailsIntent.putExtra("selectedLicense", license)
                    activity.startActivity(licenseDetailsIntent)
                }
            }
        }
    }

}