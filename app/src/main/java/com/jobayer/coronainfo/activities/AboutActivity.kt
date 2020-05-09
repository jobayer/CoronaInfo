package com.jobayer.coronainfo.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.jobayer.coronainfo.R
import com.jobayer.coronainfo.extensions.openUrl
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            R.id.menu_item_osl -> startActivity(Intent(this, LicenseActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun init() {
        initToolbar()
        initOnClick()
    }

    private fun initToolbar() {
        supportActionBar?.title = "অ্যাপ সম্পর্কিত তথ্য"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(resources.getDrawable(R.drawable.icon_back, theme))
    }

    private fun initOnClick() {
        contactMeButton.setOnClickListener {
            showContactMeDialog()
        }
        showSourceCodeButton.setOnClickListener {
            openUrl("https://github.com/jobayer/CoronaInfo")
        }
    }

    private fun showContactMeDialog() {
        val contactMeOptions = arrayOf("মেইল করুন", "ফেইসবুক")
        var selectedOption = 0
        AlertDialog.Builder(this)
            .setTitle("যোগাযোগের মাধ্যম")
            .setSingleChoiceItems(
                contactMeOptions,
                0
            ) { _, which ->
                selectedOption = which
            }
            .setPositiveButton(
                "চালিয়ে যান"
            ) { _, _ ->
                when (selectedOption) {
                    0 -> openUrl("mailto:jobayr@tuta.io")
                    1 -> openUrl("https://facebook.com/job4yr")
                }
            }
            .show()
    }
}
