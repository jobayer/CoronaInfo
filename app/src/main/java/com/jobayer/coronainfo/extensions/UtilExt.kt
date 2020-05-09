package com.jobayer.coronainfo.extensions

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.preference.PreferenceManager

fun Activity.hasCallPermission(): Boolean {
    return (ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.CALL_PHONE
    ) == PackageManager.PERMISSION_GRANTED)
}

fun Activity.requestCallPermission() {
    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 101)
}

fun Activity.makeCall(phoneNumber: String) {
    if (ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.CALL_PHONE
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        AlertDialog.Builder(this)
            .setTitle("সতর্কীকরণ")
            .setMessage("কল করার জন্য করোনা ইনফো অ্যাপ এর যথাযথ অনুমতি নেই। অনুগ্রহ করে কল করার অনুমতি দিন")
            .setPositiveButton(
                "অনুমতি দিন"
            ) { _, _ ->
                requestCallPermission()
            }
            .setNegativeButton("বিরত থাকুন", null)
            .show()
        return
    }
    AlertDialog.Builder(this)
        .setTitle("নিশ্চিতকরণ")
        .setMessage("আপনি কি কল করার ব্যাপারে নিশ্চিত?")
        .setPositiveButton(
            "হ্যা"
        ) { _, _ ->
            startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber")))
        }
        .setNegativeButton("না", null)
        .show()
}

fun Activity.isFirstRun(): Boolean {
    return PreferenceManager.getDefaultSharedPreferences(this).getBoolean("firstRun", true)
}

fun Activity.initFirstRun() {
    PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("firstRun", false).apply()
}