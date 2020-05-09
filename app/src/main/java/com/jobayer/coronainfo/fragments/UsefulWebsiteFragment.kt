package com.jobayer.coronainfo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jobayer.coronainfo.R
import com.jobayer.coronainfo.extensions.openUrl
import kotlinx.android.synthetic.main.fragment_useful_website.view.*

class UsefulWebsiteFragment : Fragment() {

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_useful_website, container, false)
        init()
        return rootView
    }

    private fun init() {
        initOnClick()
    }

    private fun initOnClick() {
        rootView.linkBtn1.setOnClickListener {
            requireActivity().openUrl("https://corona.gov.bd")
        }
        rootView.linkBtn2.setOnClickListener {
            requireActivity().openUrl("https://corona.gov.bd/telemedicine")
        }
        rootView.linkBtn3.setOnClickListener {
            requireActivity().openUrl("http://covid19tracker.gov.bd/")
        }
        rootView.linkBtn4.setOnClickListener {
            requireActivity().openUrl("https://livecoronatest.com/")
        }
        rootView.linkBtn5.setOnClickListener {
            requireActivity().openUrl("https://corona.gov.bd/service-request?service_type=3")
        }
        rootView.linkBtn6.setOnClickListener {
            requireActivity().openUrl("https://covid19.who.int/")
        }
        rootView.linkBtn7.setOnClickListener {
            requireActivity().openUrl("https://www.worldometers.info/coronavirus/")
        }
    }

}
