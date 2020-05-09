package com.jobayer.coronainfo.extensions

import android.app.Activity
import android.content.Intent
import android.net.Uri
import com.jobayer.coronainfo.Const.API_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun retrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun Activity.openUrl(url: String) {
    val linkIntent = Intent(Intent.ACTION_VIEW)
    linkIntent.data = Uri.parse(url)
    startActivity(linkIntent)
}