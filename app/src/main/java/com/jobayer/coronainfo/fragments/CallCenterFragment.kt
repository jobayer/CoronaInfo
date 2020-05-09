package com.jobayer.coronainfo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.jobayer.coronainfo.R
import com.jobayer.coronainfo.extensions.hasCallPermission
import com.jobayer.coronainfo.extensions.makeCall
import com.jobayer.coronainfo.extensions.requestCallPermission
import kotlinx.android.synthetic.main.fragment_call_center.*
import kotlinx.android.synthetic.main.fragment_call_center.view.*

class CallCenterFragment : Fragment() {

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_call_center, container, false)
        init()
        return rootView
    }

    private fun init() {
        initOnClick()
    }

    private fun initOnClick() {
        rootView.expandButton1.setOnClickListener {
            if (expandLayout1.visibility == View.GONE) {
                rootView.expandLayout1.visibility = View.VISIBLE
                rootView.expandButton1.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.icon_arrow_up,
                        requireActivity().theme
                    )
                )
            } else {
                rootView.expandLayout1.visibility = View.GONE
                rootView.expandButton1.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.icon_arrow_down,
                        requireActivity().theme
                    )
                )
            }
        }

        rootView.expandButton2.setOnClickListener {
            if (expandLayout2.visibility == View.GONE) {
                rootView.expandLayout2.visibility = View.VISIBLE
                rootView.expandButton2.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.icon_arrow_up,
                        requireActivity().theme
                    )
                )
            } else {
                rootView.expandLayout2.visibility = View.GONE
                rootView.expandButton2.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.icon_arrow_down,
                        requireActivity().theme
                    )
                )
            }
        }

        rootView.expandButton3.setOnClickListener {
            if (expandLayout3.visibility == View.GONE) {
                rootView.expandLayout3.visibility = View.VISIBLE
                rootView.expandButton3.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.icon_arrow_up,
                        requireActivity().theme
                    )
                )
            } else {
                rootView.expandLayout3.visibility = View.GONE
                rootView.expandButton3.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.icon_arrow_down,
                        requireActivity().theme
                    )
                )
            }
        }

        rootView.callBtn1.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("333")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn2.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("16263")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn3.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("10655")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn4.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("09611677777")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn5.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("109")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn6.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("+8801944333222")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn7.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("+8801937000011")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn8.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("+8801937110011")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn9.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("+8801927711784")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn10.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("+8801927711785")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn11.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("+8801306497095")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn12.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("8801306497096")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn13.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("+8801744595842")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn14.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("+8801712559673")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn15.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("+8801712177244")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn16.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("+8801713205877")
            } else requireActivity().requestCallPermission()
        }

        rootView.callBtn17.setOnClickListener {
            if (requireActivity().hasCallPermission()) {
                requireActivity().makeCall("0961167777")
            } else requireActivity().requestCallPermission()
        }
    }
}
