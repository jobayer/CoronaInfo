package com.jobayer.coronainfo.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jobayer.coronainfo.R
import com.jobayer.coronainfo.fragments.CallCenterFragment
import com.jobayer.coronainfo.fragments.UsefulWebsiteFragment
import kotlinx.android.synthetic.main.activity_help_center.*

class HelpCenterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_center)
        init()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun init() {
        initToolbar()
        initTabLayout()
    }

    private fun initToolbar() {
        supportActionBar?.title = "সাহায্য কেন্দ্র"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(resources.getDrawable(R.drawable.icon_back, theme))
    }

    private fun initTabLayout() {
        helpCenterViewPager.adapter = HelpCenterAdapter(supportFragmentManager)
        helpCenterTabLayout.setupWithViewPager(helpCenterViewPager)
    }

    class HelpCenterAdapter(fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int): Fragment {
            return if (position == 0) {
                CallCenterFragment()
            } else UsefulWebsiteFragment()
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "কল সেন্টার"
                1 -> "ওয়েবসাইট"
                else -> ""
            }
        }
    }
}
