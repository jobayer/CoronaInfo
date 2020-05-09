package com.jobayer.coronainfo.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.jobayer.coronainfo.R
import com.jobayer.coronainfo.model.License
import kotlinx.android.synthetic.main.activity_license_details.*

class LicenseDetailsActivity : AppCompatActivity() {

    private lateinit var license: License

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_license_details)
        init()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun init() {
        getLicense()
        initToolbar()
        showLicense()
    }

    private fun getLicense() {
        val data = intent.getParcelableExtra<License>("selectedLicense")
        data?.let {
            license = data
        }
    }

    private fun initToolbar() {
        supportActionBar?.title = license.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(resources.getDrawable(R.drawable.icon_back, theme))
    }

    private fun showLicense() {
        when (license.id) {
            1 -> licenseDetails.text = getString(R.string.osl_pref)
            2 -> licenseDetails.text = getString(R.string.osl_retrofit)
            3 -> licenseDetails.text = getString(R.string.osl_paper)
            4 -> licenseDetails.text = getString(R.string.osl_firebase)
            5 -> licenseDetails.text = getString(R.string.osl_github_icon)
            6 -> licenseDetails.text = getString(R.string.osl_app_icon)
        }
    }

}
